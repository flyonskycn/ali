package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.NoSign;
import com.flyonsky.ali.data.Required;

/**
 * 支付宝支付参数公共类
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonPayReq extends AbstractData{

	// 支付宝分配给开发者的应用ID
	@Required
	@JsonProperty("app_id")
	private String appId;
	
	// 接口名称
	@Required
	@JsonProperty("method")
	private String method;
	
	// 仅支持JSON
	@JsonProperty("format")
	private String format;
	
	// 请求使用的编码格式，如utf-8,gbk,gb2312等
	@Required
	@JsonProperty("charset")
	private String charset;
	
	// 商户生成签名字符串所使用的签名算法类型，目前支持RSA
	@Required
	@JsonProperty("sign_type")
	private String signType;
	
	// 商户请求参数的签名串
	@NoSign
	@Required
	@JsonProperty("sign")
	private String sign;
	
	// 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
	@Required
	@JsonProperty("timestamp")
	private String timestamp;
	
	// 调用的接口版本，固定为：1.0
	@Required
	@JsonProperty("version")
	private String version;
	
	// 应用授权概述
	@JsonProperty("app_auth_token")
	private String appAuthToken;
	
	// 请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
	@Required
	@JsonProperty("biz_content")
	private String bizContent;

	/**
	 * 支付宝分配给开发者的应用ID
	 * @return
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 支付宝分配给开发者的应用ID
	 * @param appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 接口名称
	 * @return
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 接口名称
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 仅支持JSON
	 * @return
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 仅支持JSON
	 * @param format
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * 请求使用的编码格式，如utf-8,gbk,gb2312等
	 * @return
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * 请求使用的编码格式，如utf-8,gbk,gb2312等
	 * @param charset
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * 商户生成签名字符串所使用的签名算法类型，目前支持RSA
	 * @return
	 */
	public String getSignType() {
		return signType;
	}

	/**
	 * 商户生成签名字符串所使用的签名算法类型，目前支持RSA
	 * @param signType
	 */
	public void setSignType(String signType) {
		this.signType = signType;
	}

	/**
	 * 商户请求参数的签名串
	 * @return
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 商户请求参数的签名串
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * 发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"
	 * @param timestamp
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 调用的接口版本，固定为：1.0
	 * @return
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 调用的接口版本，固定为：1.0
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * 应用授权概述
	 * @return
	 */
	public String getAppAuthToken() {
		return appAuthToken;
	}

	/**
	 * 应用授权概述
	 * @param appAuthToken
	 */
	public void setAppAuthToken(String appAuthToken) {
		this.appAuthToken = appAuthToken;
	}

	/**
	 * 请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
	 * @return
	 */
	public String getBizContent() {
		return bizContent;
	}

	/**
	 * 请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
	 * @param bizContent
	 */
	public void setBizContent(String bizContent) {
		this.bizContent = bizContent;
	}
}
