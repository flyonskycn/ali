package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.Required;

/**
 * 扫码支付的声波支付请求的非公共参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayBizContent extends TradeBizContent{

	// 支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code
	@Required
	@JsonProperty("scene")
	private String scene;
	
	// 支付授权码
	@Required
	@JsonProperty("auth_code")
	private String authCode;

	/**
	 * 支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code
	 * @return
	 */
	public String getScene() {
		return scene;
	}

	/**
	 * 支付场景 条码支付，取值：bar_code 声波支付，取值：wave_code
	 * @param scene
	 */
	public void setScene(String scene) {
		this.scene = scene;
	}

	/**
	 * 支付授权码
	 * @return
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * 
	 * @param authCode
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}
