package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.Required;

/**
 * 统一收单线下交易预创建响应数据对象
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreCreateData extends CommonResData{

	// 商户的订单号
	@Required
	@JsonProperty("out_trade_no")
	private String outTradeNo;
	
	// 当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码
	@Required
	@JsonProperty("qr_code")
	private String qrCode;

	/**
	 * 商户的订单号
	 * @return
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 商户的订单号
	 * @param outTradeNo
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码
	 * @return
	 */
	public String getQrCode() {
		return qrCode;
	}

	/**
	 * 当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码
	 * @param qrCode
	 */
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
}
