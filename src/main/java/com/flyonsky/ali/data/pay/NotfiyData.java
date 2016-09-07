package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.NoSign;
import com.flyonsky.ali.data.Required;

/**
 * 异步通知数据
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotfiyData extends AbstractData{

	// 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
	@Required
	@JsonProperty("notify_time")
	private String notifyTime;
	
	// 通知的类型
	@Required
	@JsonProperty("notify_type")
	private String notifyType;
	
	// 通知校验ID
	@Required
	@JsonProperty("notify_id")
	private String notifyId;
	
	// 支付宝分配给开发者的应用Id
	@Required
	@JsonProperty("app_id")
	private String appId;
	
	// 签名算法类型，目前支持RSA
	@NoSign
	@Required
	@JsonProperty("sign_type")
	private String signType;
	
	// 签名
	@NoSign
	@Required
	@JsonProperty("sign")
	private String sign;
	
	// 支付宝交易号
	@Required
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 商户订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 商户业务号
	@JsonProperty("out_biz_no")
	private String outBizNo;
	
	// 买家支付宝用户号
	@JsonProperty("buyer_id")
	private String buyerId;
	
	// 买家支付宝账号
	@JsonProperty("buyer_logon_id")
	private String buyerLogonId;
	
	// 卖家支付宝用户号
	@JsonProperty("seller_id")
	private String sellerId;
	
	// 卖家支付宝账号
	@JsonProperty("seller_email")
	private String sellerEmail;
	
	// 交易状态
	@JsonProperty("trade_status")
	private String tradeStatus;
	
	// 订单金额
	@JsonProperty("total_amount")
	private Double totalAmount;
	
	// 实收金额
	@JsonProperty("receipt_amount")
	private Double receiptAmount;
	
	// 开票金额
	@JsonProperty("invoice_amount")
	private Double invoiceAmount;
	
	// 付款金额
	@JsonProperty("buyer_pay_amount")
	private Double buyerPayAmount;
	
	// 集分宝金额
	@JsonProperty("point_amount")
	private Double pointAmount;
	
	// 总退款金额
	@JsonProperty("refund_fee")
	private Double refundFee;
	
	// 实际退款金额
	@JsonProperty("send_back_fee")
	private Double sendBackFee;
	
	// 订单标题
	@JsonProperty("subject")
	private String subject;
	
	// 商品描述
	@JsonProperty("body")
	private String body;
	
	// 交易创建时间
	@JsonProperty("gmt_create")
	private String gmtCreate;
	
	// 交易付款时间
	@JsonProperty("gmt_payment")
	private String gmtPayment;
	
	// 交易退款时间
	@JsonProperty("gmt_refund")
	private String gmtRefund;
	
	// 交易结束时间
	@JsonProperty("gmt_close")
	private String gmtClose;
	
	// 支付成功的各个渠道金额信息
	@JsonProperty("fund_bill_list")
	private String fundBillList;

	public String getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(String notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

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

	public String getOutBizNo() {
		return outBizNo;
	}

	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(Double receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Double getBuyerPayAmount() {
		return buyerPayAmount;
	}

	public void setBuyerPayAmount(Double buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public Double getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(Double pointAmount) {
		this.pointAmount = pointAmount;
	}

	public Double getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(Double refundFee) {
		this.refundFee = refundFee;
	}

	public Double getSendBackFee() {
		return sendBackFee;
	}

	public void setSendBackFee(Double sendBackFee) {
		this.sendBackFee = sendBackFee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getGmtPayment() {
		return gmtPayment;
	}

	public void setGmtPayment(String gmtPayment) {
		this.gmtPayment = gmtPayment;
	}

	public String getGmtRefund() {
		return gmtRefund;
	}

	public void setGmtRefund(String gmtRefund) {
		this.gmtRefund = gmtRefund;
	}

	public String getGmtClose() {
		return gmtClose;
	}

	public void setGmtClose(String gmtClose) {
		this.gmtClose = gmtClose;
	}

	public String getFundBillList() {
		return fundBillList;
	}

	public void setFundBillList(String fundBillList) {
		this.fundBillList = fundBillList;
	}
}
