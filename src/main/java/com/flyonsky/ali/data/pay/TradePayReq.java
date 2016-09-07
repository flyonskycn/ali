package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 统一收单线下交易预创建请求参数
 * 统一收单交易支付接口请求参数
 * 统一收单交易创建接口请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradePayReq extends CommonPayReq{

	// 支付宝服务器主动通知商户服务器里指定的页面http/https路径。
	@JsonProperty("notify_url")
	private String notifyUrl;

	/**
	 * 支付宝服务器主动通知商户服务器里指定的页面http/https路径。
	 * @return
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}

	/**
	 * 支付宝服务器主动通知商户服务器里指定的页面http/https路径。
	 * @param notifyUrl
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
}
