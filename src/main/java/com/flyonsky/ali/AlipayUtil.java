package com.flyonsky.ali;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.EnumSignAlgorithm;
import com.flyonsky.ali.data.EnumSignType;
import com.flyonsky.ali.data.NoSign;

/**
 * 支付宝工具类
 * @author Administrator
 *
 */
public class AlipayUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(AlipayUtil.class);
    
    // 签名算法
    private final static String SIGN_TYPE = "RSA";

    /**
     *  rsa内容签名
     * 
     * @param content 待签名的对象
     * @param privateKey 私钥
     * @param charset 字符集
     * @return
     */
    public static String rsaSign(String content, String privateKey, String charset,
                                 EnumSignType signType){
    	String sign = null;
    	switch(signType){
    	case RSA:
    		sign = rsaSign(content, privateKey, charset);
    		break;
    		default:
    			sign = rsa256Sign(content, privateKey, charset);
    			break;
    	}
    	return sign;
    }
    
    /**
     *  rsa内容签名
     * 
     * @param content 待签名的对象
     * @param privateKey 私钥
     * @param charset 字符集
     * @return
     */
    public static String rsaSign(Object content, String privateKey, String charset,
                                 EnumSignType signType){
    	String strContent = signValue(content);
    	LOG.debug(strContent);
    	String sign = null;
    	switch(signType){
    	case RSA:
    		sign = rsaSign(strContent, privateKey, charset);
    		break;
    		default:
    			sign = rsa256Sign(strContent, privateKey, charset);
    			break;
    	}
    	return sign;
    }

    /**
     * sha256WithRsa 签名
     * 
     * @param content 待签名的对象
     * @param privateKey 私钥
     * @param charset 字符集
     * @return
     */
    public static String rsa256Sign(String content, String privateKey,
                                    String charset){
    	String sign = null;
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(SIGN_TYPE,
                new ByteArrayInputStream(privateKey.getBytes()));

            Signature signature = Signature
                .getInstance(EnumSignAlgorithm.SHA256WithRSA.toString());

            signature.initSign(priKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            sign =  new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
        	LOG.error("rsa256Sign method failed : " + e.getMessage());
        }
        return sign;
    }

    /**
     * sha1WithRsa 签名
     * 
     * @param content 待签名的对象
     * @param privateKey 私钥
     * @param charset 字符集
     * @return
     */
    public static String rsaSign(String content, String privateKey,
                                 String charset){
    	String sign = null;
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(SIGN_TYPE,
                new ByteArrayInputStream(privateKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(EnumSignAlgorithm.SHA1WithRSA.toString());

            signature.initSign(priKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            byte[] signed = signature.sign();

            sign =  new String(Base64.encodeBase64(signed));
        } catch (Exception e) {
        	LOG.error("rsaSign method failed : " + e.getMessage());
        }
        return sign;
    }

    protected static PrivateKey getPrivateKeyFromPKCS8(String algorithm,
                                                    InputStream ins) throws Exception {
        if (ins == null || StringUtils.isEmpty(algorithm)) {
            return null;
        }

        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        byte[] encodedKey = IOUtils.toByteArray(ins);

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }

    /**
     * 签名验证
     * @param content 待验证数据
     * @param sign 签名
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名类型
     * @return
     */
    public static boolean rsaCheck(String content, String sign, String publicKey, String charset,
                                   EnumSignType signType){
    	boolean flag = false;
    	switch(signType){
    	case RSA2:
    		flag = rsa256CheckContent(content, sign, publicKey, charset);
    		break;
    		default:
    			flag = rsaCheckContent(content, sign, publicKey, charset);
    			break;
    	}
    	return flag;
    }
    
    /**
     * 签名验证
     * @param content 待验证数据
     * @param sign 签名
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名类型
     * @return
     */
    public static boolean rsaCheck(Object content, String sign, String publicKey, String charset,
            EnumSignType signType){
    	String strContent = signValue(content);
    	LOG.debug(strContent);
    	boolean flag = false;
    	switch(signType){
    	case RSA2:
    		flag = rsa256CheckContent(strContent, sign, publicKey, charset);
    		break;
    		default:
    			flag = rsaCheckContent(strContent, sign, publicKey, charset);
    			break;
    	}
    	return flag;
    }

    /**
     * 签名验证
     * @param content 待验证数据
     * @param sign 签名
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名类型
     * @return
     */
    public static boolean rsa256CheckContent(String content, String sign, String publicKey,
                                             String charset){
    	boolean flag = false;
        try {
            PublicKey pubKey = getPublicKeyFromX509(SIGN_TYPE,
                new ByteArrayInputStream(publicKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(EnumSignAlgorithm.SHA256WithRSA.toString());

            signature.initVerify(pubKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            flag = signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
        	LOG.error("rsa256CheckContent method failed : " + e.getMessage());
        }
        return flag;
    }

    /**
     * 签名验证
     * @param content 待验证数据
     * @param sign 签名
     * @param publicKey 公钥
     * @param charset 字符集
     * @param signType 签名类型
     * @return
     */
    public static boolean rsaCheckContent(String content, String sign, String publicKey,
                                          String charset){
    	boolean flag = false;
        try {
            PublicKey pubKey = getPublicKeyFromX509(SIGN_TYPE,
                new ByteArrayInputStream(publicKey.getBytes()));

            java.security.Signature signature = java.security.Signature
                .getInstance(EnumSignAlgorithm.SHA1WithRSA.toString());

            signature.initVerify(pubKey);

            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }

            flag = signature.verify(Base64.decodeBase64(sign.getBytes()));
        } catch (Exception e) {
        	LOG.error("rsaCheckContent method failed : " + e.getMessage());
        }
        return flag;
    }

    protected static PublicKey getPublicKeyFromX509(String algorithm,
                                                 InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);

        byte[] encodedKey = IOUtils.toByteArray(ins);

        encodedKey = Base64.decodeBase64(encodedKey);

        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }
    
	/**
	 * 将待签名对象转换为待签名字符串
	 * @param data 待签名数据
	 * @return
	 */
	protected static String signValue(Object data){
		SortedMap<String, Object> sortMap = sortMap(data);
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Object> entry : sortMap.entrySet()){
			sb.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
		}
		String str = sb.toString();
		return str.substring(0, str.lastIndexOf("&"));
	}
	
	/**
	 * 将对转为换为待签名的已排序SortedMap
	 * @param data 待签名数据
	 * @return
	 */
	protected static SortedMap<String, Object> sortMap(Object data){
		Class<?> cls = data.getClass();
		SortedMap<String, Object> sortMap = new TreeMap<String, Object>();
		Field[] fs = null;
		JsonProperty annot = null;
		NoSign noSign = null;
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
					noSign = f.getAnnotation(NoSign.class);
					if(objValue != null 
							&& StringUtils.isNotBlank(objValue.toString()) 
							&& noSign == null){
						annot = f.getAnnotation(JsonProperty.class);
						if(annot != null){
							paramName = annot.value();
						}else{
							paramName = f.getName();
						}
						sortMap.put(paramName, objValue);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					LOG.error(e.getMessage());
				}
			}
			cls = cls.getSuperclass();
		}
		return sortMap;
	}
}
