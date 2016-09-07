package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 支付宝支付响应数据公共类
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResData extends AbstractData{

	// 网关返回码
	@Required
	@JsonProperty("code")
	private String code;
	
	// 网关返回码描述
	@Required
	@JsonProperty("msg")
	private String msg;
	
	// 业务返回码
	@JsonProperty("sub_code")
	private String subCode;
	
	// 业务返回码描述
	@JsonProperty("sub_msg")
	private String subMsg;

	/**
	 * 网关返回码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 网关返回码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 网关返回码描述
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 网关返回码描述
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 业务返回码
	 * @return
	 */
	public String getSubCode() {
		return subCode;
	}

	/**
	 * 业务返回码
	 * @param subCode
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	/**
	 * 业务返回码描述
	 * @return
	 */
	public String getSubMsg() {
		return subMsg;
	}

	/**
	 * 业务返回码描述
	 * @param subMsg
	 */
	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}
}
