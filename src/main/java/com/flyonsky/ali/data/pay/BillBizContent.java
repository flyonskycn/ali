package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 查询对账单下载地址接口非公共参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillBizContent extends AbstractData{

	// 账单类型
	@Required
	@JsonProperty("bill_type")
	private String billType;
	
	// 账单时间：日账单格式为yyyy-MM-dd，月账单格式为yyyy-MM。
	@Required
	@JsonProperty("bill_date")
	private String billDate;

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
}
