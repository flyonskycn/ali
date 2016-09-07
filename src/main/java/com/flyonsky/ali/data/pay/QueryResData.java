package com.flyonsky.ali.data.pay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单线下交易查询响应数据对象
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryResData extends CommonResData{

	// 支付宝交易号
	@Required
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 商家订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 买家支付宝用户号，该字段将废弃，不要使用
	@JsonProperty("open_id")
	private String openId;
	
	// 买家支付宝账号
	@Required
	@JsonProperty("buyer_logon_id")
	private String buyerLogonId;
	
	// 交易状态
	@Required
	@JsonProperty("trade_status")
	private String tradeStatus;
	
	// 交易的订单金额，单位为元，两位小数。
	@Required
	@JsonProperty("total_amount")
	private double totalAmount;
	
	// 实收金额，单位为元，两位小数。
	@Required
	@JsonProperty("receipt_amount")
	private double receiptAmount;
	
	// 买家实付金额，单位为元，两位小数。
	@JsonProperty("buyer_pay_amount")
	private double buyerPayAmount;
	
	// 积分支付的金额，单位为元，两位小数
	@JsonProperty("point_amount")
	private double pointAmount;
	
	// 交易中用户支付的可开具发票的金额，单位为元，两位小数。
	@JsonProperty("invoice_amount")
	private double invoiceAmount;
	
	// 本次交易打款给卖家的时间
	@Required
	@JsonProperty("send_pay_date")
	private String sendPayDate;
	
	// 支付宝店铺编号
	@JsonProperty("alipay_store_id")
	private String alipayStoreId;
	
	// 商户门店编号
	@JsonProperty("store_id")
	private String storeId;
	
	// 商户机具终端编号
	@JsonProperty("terminal_id")
	private String terminalId;
	
	// 交易支付使用的资金渠道
	@JsonProperty("fund_bill_list")
	private List<TradeFundBill> fundBillList;
	
	// 请求交易支付中的商户店铺的名称
	@JsonProperty("store_name")
	private String storeName;
	
	// 买家在支付宝的用户id
	@Required
	@JsonProperty("buyer_user_id")
	private String buyerUserId;
	
	// 本次交易支付所使用的单品券优惠的商品优惠信息
	@JsonProperty("discount_goods_detail")
	private String discount_goods_detail;
	
	// 行业特殊信息（例如在医保卡支付业务中，向用户返回医疗信息）。
	@JsonProperty("industry_sepc_detail")
	private String industry_sepc_detail;

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

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(double receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public double getBuyerPayAmount() {
		return buyerPayAmount;
	}

	public void setBuyerPayAmount(double buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public double getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(double pointAmount) {
		this.pointAmount = pointAmount;
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getSendPayDate() {
		return sendPayDate;
	}

	public void setSendPayDate(String sendPayDate) {
		this.sendPayDate = sendPayDate;
	}

	public String getAlipayStoreId() {
		return alipayStoreId;
	}

	public void setAlipayStoreId(String alipayStoreId) {
		this.alipayStoreId = alipayStoreId;
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

	public List<TradeFundBill> getFundBillList() {
		return fundBillList;
	}

	public void setFundBillList(List<TradeFundBill> fundBillList) {
		this.fundBillList = fundBillList;
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

	public String getDiscount_goods_detail() {
		return discount_goods_detail;
	}

	public void setDiscount_goods_detail(String discount_goods_detail) {
		this.discount_goods_detail = discount_goods_detail;
	}

	public String getIndustry_sepc_detail() {
		return industry_sepc_detail;
	}

	public void setIndustry_sepc_detail(String industry_sepc_detail) {
		this.industry_sepc_detail = industry_sepc_detail;
	}
}
