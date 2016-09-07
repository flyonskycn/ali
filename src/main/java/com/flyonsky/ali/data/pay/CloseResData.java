package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 统一收单交易关闭接口响应数据
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloseResData extends CommonResData{

	// 支付宝交易号
	@JsonProperty("trade_no")
	private String tradeNo;
	
	// 创建交易传入的商户订单号
	@JsonProperty("out_trade_no")
	private String outTradeNo;

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
}
