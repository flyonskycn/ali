package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;

/**
 * 统一收单交易撤销接口请求的非公共参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelBizContent extends AbstractData{

	// 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 支付宝交易号，和商户订单号不能同时为空
	@JsonProperty("trade_no")
	private String tradeNo;

	/**
	 * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 支付宝交易号，和商户订单号不能同时为空
	 * @return
	 */
	public String getTradeNo() {
		return tradeNo;
	}
	
	/**
	 * 支付宝交易号，和商户订单号不能同时为空
	 * @param tradeNo
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
}
