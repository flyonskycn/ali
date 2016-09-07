package com.flyonsky.ali.data.pay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 描述分账信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoyaltyInfo extends AbstractData{

	// 分账类型 卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。
	@JsonProperty("royalty_type")
	private String royaltyType;
	
	// 分账明细的信息，可以描述多条分账指令
	@Required
	@JsonProperty("royalty_detail_infos")
	private List<RoyaltyDetailInfo> royaltyDetailInfos;

	/**
	 * 分账类型 卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。
	 * @return
	 */
	public String getRoyaltyType() {
		return royaltyType;
	}

	/**
	 * 分账类型 卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。
	 * @param royaltyType
	 */
	public void setRoyaltyType(String royaltyType) {
		this.royaltyType = royaltyType;
	}

	/**
	 * 分账明细的信息，可以描述多条分账指令
	 * @return
	 */
	public List<RoyaltyDetailInfo> getRoyaltyDetailInfos() {
		return royaltyDetailInfos;
	}

	/**
	 * 分账明细的信息，可以描述多条分账指令
	 * @param royaltyDetailInfos
	 */
	public void setRoyaltyDetailInfos(List<RoyaltyDetailInfo> royaltyDetailInfos) {
		this.royaltyDetailInfos = royaltyDetailInfos;
	}
	
}
