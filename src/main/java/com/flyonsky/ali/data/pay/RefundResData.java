package com.flyonsky.ali.data.pay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单交易退款接口响应数据
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefundResData extends CommonResData{

	// 支付宝交易号
	@Required
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 商户订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 买家支付宝用户号，该参数已废弃，请不要使用
	@Required
	@JsonProperty("open_id")
	private String openId;
	
	// 用户的登录id
	@Required
	@JsonProperty("buyer_logon_id")
	private String buyerLogonId;
	
	// 本次退款是否发生了资金变化
	@Required
	@JsonProperty("fund_change")
	private String fundChange;
	
	// 退款总金额
	@Required
	@JsonProperty("refund_fee")
	private String refundFee;
	
	// 退款支付时间
	@Required
	@JsonProperty("gmt_refund_pay")
	private String gmtRefundPay;
	
	// 退款使用的资金渠道
	@JsonProperty("refund_detail_item_list")
	private List<TradeFundBill> refundDetailItemList;
	
	// 交易在支付时候的门店名称
	@JsonProperty("store_name")
	private String storeName;
	
	// 买家在支付宝的用户id
	@Required
	@JsonProperty("buyer_user_id")
	private String buyerUserId;
	
	// 本次商户实际退回金额
	@JsonProperty("send_back_fee")
	private String sendBackFee;

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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getFundChange() {
		return fundChange;
	}

	public void setFundChange(String fundChange) {
		this.fundChange = fundChange;
	}

	public String getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}

	public String getGmtRefundPay() {
		return gmtRefundPay;
	}

	public void setGmtRefundPay(String gmtRefundPay) {
		this.gmtRefundPay = gmtRefundPay;
	}

	public List<TradeFundBill> getRefundDetailItemList() {
		return refundDetailItemList;
	}

	public void setRefundDetailItemList(List<TradeFundBill> refundDetailItemList) {
		this.refundDetailItemList = refundDetailItemList;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public String getSendBackFee() {
		return sendBackFee;
	}

	public void setSendBackFee(String sendBackFee) {
		this.sendBackFee = sendBackFee;
	}
}
