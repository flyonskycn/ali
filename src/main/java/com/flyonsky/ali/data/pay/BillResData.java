package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 查询对账单下载地址响应数据
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillResData extends CommonResData{

	// 账单下载地址链接，获取连接后30秒后未下载，链接地址失效。
	@JsonProperty("bill_download_url")
	private String billDownloadUrl;

	public String getBillDownloadUrl() {
		return billDownloadUrl;
	}

	public void setBillDownloadUrl(String billDownloadUrl) {
		this.billDownloadUrl = billDownloadUrl;
	}
}
