package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 手机网页支付接口非公共参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WapBizContent extends AbstractData{

	// 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	@JsonProperty("body")
	private String body;
	
	// 商品的标题/交易标题/订单标题/订单关键字等。
	@Required
	@JsonProperty("subject")
	private String subject;
	
	// 商户网站唯一订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	@JsonProperty("timeout_express")
	private String timeoutExpress;
	
	// 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	@Required
	@JsonProperty("total_amount")
	private double totalAmount;
	
	// 收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	@JsonProperty("seller_id")
	private String sellerId;
	
	// 针对用户授权接口，获取用户相关数据时，用于标识用户授权关系
	@JsonProperty("auth_token")
	private String authToken;
	
	// 销售产品码，商家和支付宝签约的产品码
	@Required
	@JsonProperty("product_code")
	private String productCode;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
