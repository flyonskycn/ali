package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 资金渠道
 * @author Administrator
 *
 */
public class TradeFundBill extends AbstractData{

	// 交易使用的资金渠道
	@Required
	@JsonProperty("fund_channel")
	private String fundChannel;
	
	// 该支付工具类型所使用的金额
	@JsonProperty("amount")
	private Double amount;
	
	// 渠道实际付款金额
	@JsonProperty("real_amount")
	private Double realAmount;

	/**
	 * 交易使用的资金渠道
	 * @return
	 */
	public String getFundChannel() {
		return fundChannel;
	}

	/**
	 * 交易使用的资金渠道
	 * @param fundChannel
	 */
	public void setFundChannel(String fundChannel) {
		this.fundChannel = fundChannel;
	}

	/**
	 * 该支付工具类型所使用的金额
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * 该支付工具类型所使用的金额
	 * @param amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 渠道实际付款金额
	 * @return
	 */
	public Double getRealAmount() {
		return realAmount;
	}

	/**
	 * 渠道实际付款金额
	 * @param realAmount
	 */
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}
}
