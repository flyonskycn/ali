package com.flyonsky.ali.data.pay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单交易支付接口响应数据部分
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayResData extends CommonResData{

	// 支付宝交易号
	@Required
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 商户订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 买家支付宝账号
	@Required
	@JsonProperty("buyer_logon_id")
	private String buyerLogonId;
	
	// 交易金额
	@Required
	@JsonProperty("total_amount")
	private double totalAmount;
	
	// 实收金额
	@Required
	@JsonProperty("receipt_amount")
	private double receiptAmount;
	
	// 买家付款的金额
	@JsonProperty("buyer_pay_amount")
	private double buyerPayAmount;
	
	// 使用积分宝付款的金额
	@JsonProperty("point_amount")
	private double pointAmount;
	
	// 交易中可给用户开具发票的金额
	@JsonProperty("invoice_amount")
	private double invoiceAmount;
	
	// 交易支付时间
	@Required
	@JsonProperty("gmt_payment")
	private String gmtPayment;
	
	// 交易支付使用的资金渠道
	@Required
	@JsonProperty("fund_bill_list")
	private List<TradeFundBill> fundBillList;
	
	// 支付宝卡余额
	@JsonProperty("card_balance")
	private double cardBalance;
	
	// 发生支付交易的商户门店名称
	@JsonProperty("store_name")
	private String storeName;
	
	// 买家在支付宝的用户id
	@Required
	@JsonProperty("buyer_user_id")
	private String buyerUserId;
	
	// 本次交易支付所使用的单品券优惠的商品优惠信息
	@Required
	@JsonProperty("discount_goods_detail")
	private String discountGoodsDetail;

	/**
	 * 支付宝交易号
	 * @return
	 */
	public String getTradeNo() {
		return tradeNo;
	}

	/**
	 * 支付宝交易号
	 * @param tradeNo
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	/**
	 * 商户订单号
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 商户订单号
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 买家支付宝账号
	 * @return
	 */
	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	/**
	 * 买家支付宝账号
	 * @param buyerLogonId
	 */
	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	/**
	 * 交易金额
	 * @return
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 交易金额
	 * @param totalAmount
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 实收金额
	 * @return
	 */
	public double getReceiptAmount() {
		return receiptAmount;
	}

	/**
	 * 实收金额
	 * @param receiptAmount
	 */
	public void setReceiptAmount(double receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	/**
	 * 买家付款的金额
	 * @return
	 */
	public double getBuyerPayAmount() {
		return buyerPayAmount;
	}

	/**
	 * 买家付款的金额
	 * @param buyerPayAmount
	 */
	public void setBuyerPayAmount(double buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	/**
	 * 使用积分宝付款的金额
	 * @return
	 */
	public double getPointAmount() {
		return pointAmount;
	}

	/**
	 * 使用积分宝付款的金额
	 * @param pointAmount
	 */
	public void setPointAmount(double pointAmount) {
		this.pointAmount = pointAmount;
	}

	/**
	 * 交易中可给用户开具发票的金额
	 * @return
	 */
	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	/**
	 * 交易中可给用户开具发票的金额
	 * @param invoiceAmount
	 */
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	/**
	 * 交易支付时间
	 * @return
	 */
	public String getGmtPayment() {
		return gmtPayment;
	}

	/**
	 * 交易支付时间
	 * @param gmtPayment
	 */
	public void setGmtPayment(String gmtPayment) {
		this.gmtPayment = gmtPayment;
	}

	/**
	 * 交易支付使用的资金渠道
	 * @return
	 */
	public List<TradeFundBill> getFundBillList() {
		return fundBillList;
	}

	/**
	 * 交易支付使用的资金渠道
	 * @param fundBillList
	 */
	public void setFundBillList(List<TradeFundBill> fundBillList) {
		this.fundBillList = fundBillList;
	}

	/**
	 * 支付宝卡余额
	 * @return
	 */
	public double getCardBalance() {
		return cardBalance;
	}

	/**
	 * 支付宝卡余额
	 * @param cardBalance
	 */
	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	/**
	 * 发生支付交易的商户门店名称
	 * @return
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * 发生支付交易的商户门店名称
	 * @param storeName
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * 买家在支付宝的用户id
	 * @return
	 */
	public String getBuyerUserId() {
		return buyerUserId;
	}

	/**
	 * 买家在支付宝的用户id
	 * @param buyerUserId
	 */
	public void setBuyerUserId(String buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	/**
	 * 本次交易支付所使用的单品券优惠的商品优惠信息
	 * @return
	 */
	public String getDiscountGoodsDetail() {
		return discountGoodsDetail;
	}

	/**
	 * 本次交易支付所使用的单品券优惠的商品优惠信息
	 * @param discountGoodsDetail
	 */
	public void setDiscountGoodsDetail(String discountGoodsDetail) {
		this.discountGoodsDetail = discountGoodsDetail;
	}
}
