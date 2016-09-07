package com.flyonsky.ali;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.flyonsky.ali.data.EnumContentType;
import com.flyonsky.ali.data.EnumSignType;

/**
 * 与微信后台交互的http基础类
 * @author Administrator
 *
 */
abstract class AbstractHandle {
	
	protected static final Logger LOG = LoggerFactory.getLogger(AbstractHandle.class);
	
	/**
	 *  http head 中的 contentType名称
	 */
	protected static final String CONTENTTYPE_HEAD = "Content-Type"; 
	
	/**
	 * json 的ContentType
	 */
	protected static final String JSON_CONTENTTYPE = "application/json";
	
	/**
	 * xml 的ContentType
	 */
	protected static final String XML_CONTENTTYPE = "text/xml";
	
	/**
	 * 黙认的编码类型
	 */
	protected static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 以get方式执行url,并将结果以java对象方式返回
	 * @param url URL地址
	 * @param cls java对象的class
	 * @return
	 */
	protected <T> T doGet(String url, Class<?> cls){
		return this.doGet(url, cls, EnumContentType.json);
	}
	
	/**
	 * 以get方式执行url,并将结果以java对象方式返回
	 * @param url URL地址
	 * @param cls java对象的class
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected <T> T doGet(String url, Class<?> cls, EnumContentType resultType){
		HttpGet httpGet = new HttpGet(url);
		return this.execute(httpGet, cls, resultType);
	}
	
	/**
	 * 以post方式执行url
	 * @param url url地址
	 * @param param 参数对象
	 * @param cls java对的class
	 * @return
	 */
	protected <T> T doPost(String url, Object param, Class<?> cls){
		return this.doPost(url,
				param,
				cls,
				EnumContentType.json,
				EnumContentType.json);
	}
	
	/**
	 * 以post方式执行url
	 * @param url url地址
	 * @param param 参数对象
	 * @param cls 响应结果java对的class
	 * @param paramType post参数的java对象转换为成对应类型的字符串表示
	 * @param resultType 响应字符串表示的类型
	 * @return
	 */
	protected <T> T doPost(String url,
			Object param, Class<?> cls,
			EnumContentType paramType,
			EnumContentType resultType){
		HttpPost httpPost = new HttpPost(url);
		HttpEntity entity = null;
		String paramData = null;
		switch(paramType){
		case xml:
			httpPost.addHeader(CONTENTTYPE_HEAD, XML_CONTENTTYPE);
			paramData = this.javaToXml(param);
			entity = new StringEntity(paramData, DEFAULT_CHARSET);
			break;
			default:
				entity = javaToHttpEntity(param);
				break;
		}
		LOG.debug(paramData);
		httpPost.setEntity(entity);
		
		return this.execute(httpPost, cls, resultType);
	}
	
	/**
	 * 以post方式执行url并且以公钥验证签名
	 * @param url url地址
	 * @param param 参数对象
	 * @param cls 响应结果java对的class
	 * @param publicKey 验证响应的公钥
	 * @return
	 */
	protected <T> T checkPost(String url,Object param, Class<?> cls,String publicKey){
		HttpPost httpPost = new HttpPost(url);
		HttpEntity entity = javaToHttpEntity(param);
		
		httpPost.setEntity(entity);
		
		return this.execute(httpPost, cls, publicKey);
	}
	
	/**
	 * 通用的简单对象结果返回
	 * @param request 请求对象
	 * @param cls 响应结果的java对象的class
	 * @param resultType 结果返回字符串对象类型
	 * @return
	 */
	private <T> T execute(HttpUriRequest request, Class<?> cls, EnumContentType resultType){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(request);
            HttpEntity entity1 = response1.getEntity();
            String value = EntityUtils.toString(entity1, Charset.forName(DEFAULT_CHARSET));
            LOG.debug(value);
            LOG.debug(response1.getFirstHeader(CONTENTTYPE_HEAD).getValue());
            switch(resultType){
            case xml:
            	result = this.xmlToJava(value, cls);
            	break;
            	default:
            		result = this.jsonToJava(value, cls);
            		break;
            }
		} catch (IOException e) {
			LOG.error(e.getMessage());
		} finally {
            try {
				response1.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
        }
		return result;
	}
	
	/**
	 * 通用的简单对象结果返回
	 * @param request 请求对象
	 * @param cls 响应结果的java对象的class
	 * @param publicKey 验证公钥
	 * @return
	 */
	private <T> T execute(HttpUriRequest request, Class<?> cls, String publicKey){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		T result = null;
		CloseableHttpResponse response1 = null;
		try {
			response1 = httpclient.execute(request);
            HttpEntity entity1 = response1.getEntity();
            String value = EntityUtils.toString(entity1, Charset.forName(DEFAULT_CHARSET));
            LOG.debug(value);
            LOG.debug(response1.getFirstHeader(CONTENTTYPE_HEAD).getValue());
            Pattern p = Pattern.compile("response\":(\\{.*\\}),.*\"sign\":\"(.*)\"");
            Matcher m = p.matcher(value);
            if(m.find()){
            	String json = m.group(1);
            	String sign = m.group(2);
                boolean check = AlipayUtil.rsaCheck(json, sign, publicKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
                if(check){
                	result = this.jsonToJava(json, cls);
                }else{
                	LOG.debug("支付宝响应消息签名验证失败");
                	result = null;
                }
            }
		} catch (IOException e) {
			LOG.error(e.getMessage());
		} finally {
            try {
				response1.close();
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
        }
		return result;
	}
	
	/**
	 * 将xml字符串转换为java对象
	 * @param xml xml字符串
	 * @param cls java对象class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T xmlToJava(String xml, Class<?> cls){
		XmlMapper mapper = new XmlMapper();
		T value = null;
		try {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			value = (T) mapper.readValue(xml, cls);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
	
	/**
	 * 将java对象转换为xml字符串
	 * @param obj java对象
 	 * @return xml字符串
	 */
	protected String javaToXml(Object obj) {
		XmlMapper xmlMapper = new XmlMapper();
		String xml = null;
		try {
			xml = xmlMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return xml;
	}
	
	/**
	 * 将java对象转换为json字符串表示
	 * @param obj 待转换为json字符串的java对象
	 * @return json字符串
	 */
	protected String javaToJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOG.error(e.getMessage());
		}
		return json;
	}
	
	/**
	 * 将json字符串表示成java对象
	 * @param json java对象的json字符串表示
	 * @param cls 转换为对应java对象的class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T jsonToJava(String json, Class<?> cls){
		ObjectMapper mapper = new ObjectMapper();
		T value = null;
		try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			value = (T) mapper.readValue(json, cls);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return value;
	}
	
	/**
	 * 将java对象转换为http请求的参数
	 * @param data java对象
	 * @return
	 */
	protected HttpEntity javaToHttpEntity(Object data){
		Class<?> cls = data.getClass();
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		NameValuePair pair = null;
		Field[] fs = null;
		JsonProperty annot = null;
		Object objValue = null;
		String paramName = null;
		while(!cls.equals(Object.class)){
			fs = cls.getDeclaredFields();
			for(Field f : fs){
				if(Modifier.isStatic(f.getModifiers()))
					break;
				try {
					f.setAccessible(true);
					objValue = f.get(data);
					if(objValue != null 
							&& StringUtils.isNotBlank(objValue.toString()) ){
						annot = f.getAnnotation(JsonProperty.class);
						if(annot != null){
							paramName = annot.value();
						}else{
							paramName = f.getName();
						}
						pair = new BasicNameValuePair(paramName,objValue.toString());
						parameters.add(pair);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					LOG.error(e.getMessage());
				}
			}
			cls = cls.getSuperclass();
		}
		HttpEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(parameters,DEFAULT_CHARSET);
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage());
		}
		return entity;
	}
}
