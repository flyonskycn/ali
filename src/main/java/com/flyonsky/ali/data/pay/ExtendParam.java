package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;

/**
 * 业务扩展参数
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendParam extends AbstractData{

	// 系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	@JsonProperty("sys_service_provider_id")
	private String sysServiceProviderId;
	
	// 使用花呗分期要进行的分期数
	@JsonProperty("hb_fq_num")
	private String hbFqNum;
	
	// 使用花呗分期需要卖家承担的手续费比例的百分值，传入100代表100%
	@JsonProperty("hb_fq_seller_percent")
	private String hbFqSellerPercent;

	/**
	 * 系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	 * @return
	 */
	public String getSysServiceProviderId() {
		return sysServiceProviderId;
	}

	/**
	 * 系统商编号 该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	 * @param sysServiceProviderId
	 */
	public void setSysServiceProviderId(String sysServiceProviderId) {
		this.sysServiceProviderId = sysServiceProviderId;
	}

	/**
	 * 使用花呗分期要进行的分期数
	 * @return
	 */
	public String getHbFqNum() {
		return hbFqNum;
	}

	/**
	 * 使用花呗分期要进行的分期数
	 * @param hbFqNum
	 */
	public void setHbFqNum(String hbFqNum) {
		this.hbFqNum = hbFqNum;
	}

	/**
	 * 使用花呗分期需要卖家承担的手续费比例的百分值，传入100代表100%
	 * @return
	 */
	public String getHbFqSellerPercent() {
		return hbFqSellerPercent;
	}

	/**
	 * 使用花呗分期需要卖家承担的手续费比例的百分值，传入100代表100%
	 * @param hbFqSellerPercent
	 */
	public void setHbFqSellerPercent(String hbFqSellerPercent) {
		this.hbFqSellerPercent = hbFqSellerPercent;
	}
}
