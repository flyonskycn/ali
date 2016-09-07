package com.flyonsky.ali.data.pay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单线下交易预创建非公共请求参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TradeBizContent extends AbstractData{

	// 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	@JsonProperty("seller_id")
	private String sellerId;
	
	// 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
	@Required
	@JsonProperty("total_amount")
	private double totalAmount;
	
	// 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】
	@JsonProperty("discountable_amount")
	private Double discountableAmount;
	
	// 不可打折金额. 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】,【打折金额】，则该值默认为【订单总金额】-【打折金额】
	@JsonProperty("undiscountable_amount")
	private Double undiscountableAmount;
	
	// 买家支付宝账号
	@JsonProperty("buyer_logon_id")
	private String buyerLogonId;
	
	// 订单标题
	@Required
	@JsonProperty("subject")
	private String subject;
	
	// 对交易或商品的描述
	@JsonProperty("body")
	private String body;
	
	// 订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”
	@JsonProperty("goods_detail")
	private List<GoodsDetail> goodsDetail;
	
	// 商户操作员编号
	@JsonProperty("operator_id")
	private String operatorId;
	
	// 商户门店编号
	@JsonProperty("store_id")
	private String storeId;
	
	// 商户机具终端编号
	@JsonProperty("terminal_id")
	private String terminalId;
	
	// 业务扩展参数
	@JsonProperty("extend_params")
	private ExtendParam extendParams;
	
	// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	@JsonProperty("timeout_express")
	private String timeoutExpress;
	
	// 描述分账信息，json格式。
	@JsonProperty("royalty_info")
	private RoyaltyInfo royaltyInfo;
	
	// 二级商户信息,当前只对特殊银行机构特定场景下使用此字段
	@JsonProperty("sub_merchant")
	private SubMerchant subMerchant;
	
	// 支付宝店铺的门店ID
	@JsonProperty("alipay_store_id")
	private String alipayStoreId;

	/**
	 * 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 *  商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 *  卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	 * @return
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	 * @param sellerId
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 
	 * 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，
	 * 则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
	 * @return
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 
	 * 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，
	 * 则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
	 * @param totalAmount
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】
	 * @return
	 */
	public Double getDiscountableAmount() {
		return discountableAmount;
	}

	/**
	 * 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 
	 * 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】
	 * @param discountableAmount
	 */
	public void setDiscountableAmount(Double discountableAmount) {
		this.discountableAmount = discountableAmount;
	}

	/**
	 * 不可打折金额. 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 
	 * 如果该值未传入，但传入了【订单总金额】,【打折金额】，则该值默认为【订单总金额】-【打折金额】
	 * @return
	 */
	public Double getUndiscountableAmount() {
		return undiscountableAmount;
	}

	/**
	 * 不可打折金额. 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 
	 * 如果该值未传入，但传入了【订单总金额】,【打折金额】，则该值默认为【订单总金额】-【打折金额】
	 * @param undiscountableAmount
	 */
	public void setUndiscountableAmount(Double undiscountableAmount) {
		this.undiscountableAmount = undiscountableAmount;
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
	 * 订单标题
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 订单标题
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 对交易或商品的描述
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 对交易或商品的描述
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”
	 * @return
	 */
	public List<GoodsDetail> getGoodsDetail() {
		return goodsDetail;
	}

	/**
	 * 订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”
	 * @param goodsDetail
	 */
	public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	/**
	 * 商户操作员编号
	 * @return
	 */
	public String getOperatorId() {
		return operatorId;
	}

	/**
	 * 商户操作员编号
	 * @param operatorId
	 */
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	/**
	 * 商户门店编号
	 * @return
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * 商户门店编号
	 * @param storeId
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/**
	 * 商户机具终端编号
	 * @return
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * 商户机具终端编号
	 * @param terminalId
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * 业务扩展参数
	 * @return
	 */
	public ExtendParam getExtendParams() {
		return extendParams;
	}

	/**
	 * 业务扩展参数
	 * @param extendParams
	 */
	public void setExtendParams(ExtendParam extendParams) {
		this.extendParams = extendParams;
	}

	/**
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。
	 * 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
	 * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	 * @return
	 */
	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	/**
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。
	 * 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 
	 * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	 * @param timeoutExpress
	 */
	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	/**
	 * 描述分账信息，json格式。
	 * @return
	 */
	public RoyaltyInfo getRoyaltyInfo() {
		return royaltyInfo;
	}

	/**
	 * 描述分账信息，json格式。
	 * @param royaltyInfo
	 */
	public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
		this.royaltyInfo = royaltyInfo;
	}

	/**
	 * 二级商户信息,当前只对特殊银行机构特定场景下使用此字段
	 * @return
	 */
	public SubMerchant getSubMerchant() {
		return subMerchant;
	}

	/**
	 * 二级商户信息,当前只对特殊银行机构特定场景下使用此字段
	 * @param subMerchant
	 */
	public void setSubMerchant(SubMerchant subMerchant) {
		this.subMerchant = subMerchant;
	}

	/**
	 * 支付宝店铺的门店ID
	 * @return
	 */
	public String getAlipayStoreId() {
		return alipayStoreId;
	}

	/**
	 * 支付宝店铺的门店ID
	 * @param alipayStoreId
	 */
	public void setAlipayStoreId(String alipayStoreId) {
		this.alipayStoreId = alipayStoreId;
	}
}
