package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 查询退款单接口响应数据
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryRefundResData extends CommonResData{

	// 支付宝交易号
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 创建交易传入的商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 本笔退款对应的退款请求号
	@JsonProperty("out_request_no")
	private String outRequestNo;
	
	// 发起退款时，传入的退款原因
	@JsonProperty("refund_reason")
	private String refundReason;
	
	// 该笔退款所对应的交易的订单金额
	@JsonProperty("total_amount")
	private double totalAmount;
	
	// 本次退款请求，对应的退款金额
	@JsonProperty("refund_amount")
	private double refundAmount;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

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

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}
}
