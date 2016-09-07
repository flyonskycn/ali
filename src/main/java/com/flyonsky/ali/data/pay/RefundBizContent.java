package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单交易退款接口请求的非公共参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefundBizContent extends AbstractData{

	// 订单支付时传入的商户订单号,不能和 trade_no同时为空。
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 支付宝交易号，和商户订单号不能同时为空
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	@Required
	@JsonProperty("refund_amount")
	private double refundAmount;
	
	// 退款的原因说明
	@JsonProperty("refund_reason")
	private String refundReason;
	
	// 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
	@JsonProperty("out_request_no")
	private String outRequestNo;
	
	// 商户的操作员编号
	@JsonProperty("operator_id")
	private String operatorId;
	
	// 商户的门店编号
	@JsonProperty("store_id")
	private String storeId;
	
	// 商户的终端编号
	@JsonProperty("terminal_id")
	private String terminalId;

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public double getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
}
