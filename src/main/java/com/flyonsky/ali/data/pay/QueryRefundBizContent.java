package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 查询退款单接口非公共参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryRefundBizContent extends AbstractData{

	// 支付宝交易号，和商户订单号不能同时为空
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
	@Required
	@JsonProperty("out_request_no")
	private String outRequestNo;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
}
