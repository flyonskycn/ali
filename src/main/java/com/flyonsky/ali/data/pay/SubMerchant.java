package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 二级商户信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubMerchant extends AbstractData{

	// 二级商户的支付宝id
	@Required
	@JsonProperty("merchant_id")
	private String merchantId;

	/**
	 * 二级商户的支付宝id
	 * @return
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * 二级商户的支付宝id
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}
