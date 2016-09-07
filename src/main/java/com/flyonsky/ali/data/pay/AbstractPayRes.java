package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.NoSign;
import com.flyonsky.ali.data.Required;

/**
 * 支付宝支付响应抽象类
 * @author Administrator
 *
 */
public abstract class AbstractPayRes extends AbstractData{
	
	// 签名
	@NoSign
	@Required
	@JsonProperty("sign")
	private String sign;

	/**
	 * 签名
	 * @return
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 签名
	 * @param sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
}
