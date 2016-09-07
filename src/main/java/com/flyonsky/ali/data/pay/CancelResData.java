package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单交易撤销接口响应数据对象
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelResData extends CommonResData{

	// 支付宝交易号
	@Required
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 商户订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 是否需要重试
	@Required
	@JsonProperty("retry_flag")
	private String retryFlag;
	
	// 本次撤销触发的交易动作 close：关闭交易，无退款 refund：产生了退款
	@Required
	@JsonProperty("action")
	private String action;

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

	public String getRetryFlag() {
		return retryFlag;
	}

	public void setRetryFlag(String retryFlag) {
		this.retryFlag = retryFlag;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
