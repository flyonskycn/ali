package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 分账明细的信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoyaltyDetailInfo extends AbstractData{

	// 分账序列号，表示分账执行的顺序，必须为正整数
	@JsonProperty("serial_no")
	private int serialNo;
	
	// 接受分账金额的账户类型,默认值为userId。
	@JsonProperty("trans_in_type")
	private String transInType;
	
	// 分账批次号 分账批次号。 目前需要和转入账号类型为bankIndex配合使用。
	@Required
	@JsonProperty("batch_no")
	private String batchNo;
	
	// 商户分账的外部关联号，用于关联到每一笔分账信息，商户需保证其唯一性。 如果为空，该值则默认为“商户网站唯一订单号+分账序列号”
	@JsonProperty("out_relation_id")
	private String outRelationId;
	
	// 要分账的账户类型。 目前只支持userId：支付宝账号对应的支付宝唯一用户号。 默认值为userId。
	@Required
	@JsonProperty("trans_out_type")
	private String transOutType;
	
	// 如果转出账号类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	@Required
	@JsonProperty("trans_out")
	private String transOut;
	
	// 如果转入账号类型为userId，本参数为接受分账金额的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 	如果转入账号类型为bankIndex，本参数为28位的银行编号（商户和支付宝签约时确定）。 如果转入账号类型为storeId，本参数为商户的门店ID。
	@Required
	@JsonProperty("trans_in")
	private String transIn;
	
	// 分账的金额，单位为元
	@Required
	@JsonProperty("amount")
	private double amount;
	
	// 分账描述信息
	@JsonProperty("desc")
	private String desc;
	
	// 分账的比例，值为20代表按20%的比例分账
	@JsonProperty("amount_percentage")
	private String amountPercentage;

	/**
	 * 分账序列号，表示分账执行的顺序，必须为正整数
	 * @return
	 */
	public int getSerialNo() {
		return serialNo;
	}

	/**
	 * 分账序列号，表示分账执行的顺序，必须为正整数
	 * @param serialNo
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * 接受分账金额的账户类型,默认值为userId。
	 * @return
	 */
	public String getTransInType() {
		return transInType;
	}

	/**
	 * 接受分账金额的账户类型,默认值为userId。
	 * @param transInType
	 */
	public void setTransInType(String transInType) {
		this.transInType = transInType;
	}

	/**
	 * 分账批次号 分账批次号。 目前需要和转入账号类型为bankIndex配合使用。
	 * @return
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * 分账批次号 分账批次号。 目前需要和转入账号类型为bankIndex配合使用。
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * 商户分账的外部关联号，用于关联到每一笔分账信息，商户需保证其唯一性。 如果为空，该值则默认为“商户网站唯一订单号+分账序列号”
	 * @return
	 */
	public String getOutRelationId() {
		return outRelationId;
	}

	/**
	 * 商户分账的外部关联号，用于关联到每一笔分账信息，商户需保证其唯一性。 如果为空，该值则默认为“商户网站唯一订单号+分账序列号”
	 * @param outRelationId
	 */
	public void setOutRelationId(String outRelationId) {
		this.outRelationId = outRelationId;
	}

	/**
	 * 要分账的账户类型。 目前只支持userId：支付宝账号对应的支付宝唯一用户号。 默认值为userId。
	 * @return
	 */
	public String getTransOutType() {
		return transOutType;
	}

	/**
	 * 要分账的账户类型。 目前只支持userId：支付宝账号对应的支付宝唯一用户号。 默认值为userId。
	 * @param transOutType
	 */
	public void setTransOutType(String transOutType) {
		this.transOutType = transOutType;
	}

	/**
	 * 如果转出账号类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	 * @return
	 */
	public String getTransOut() {
		return transOut;
	}

	/**
	 * 如果转出账号类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。
	 * @param transOut
	 */
	public void setTransOut(String transOut) {
		this.transOut = transOut;
	}

	/**
	 * 如果转入账号类型为userId，本参数为接受分账金额的支付宝账号对应的支付宝唯一用户号
	 * @return
	 */
	public String getTransIn() {
		return transIn;
	}

	/**
	 * 如果转入账号类型为userId，本参数为接受分账金额的支付宝账号对应的支付宝唯一用户号
	 * @param transIn
	 */
	public void setTransIn(String transIn) {
		this.transIn = transIn;
	}

	/**
	 * 分账的金额，单位为元
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * 分账的金额，单位为元
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * 分账描述信息
	 * @return
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 分账描述信息
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 分账的比例，值为20代表按20%的比例分账
	 * @return
	 */
	public String getAmountPercentage() {
		return amountPercentage;
	}

	/**
	 * 分账的比例，值为20代表按20%的比例分账
	 * @param amountPercentage
	 */
	public void setAmountPercentage(String amountPercentage) {
		this.amountPercentage = amountPercentage;
	}
}
