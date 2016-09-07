package com.flyonsky.ali.data;

/**
 * 分帐类型枚举
 * @author Administrator
 *
 */
public enum EnumTransType {
	/**
	 * 支付宝账号对应的支付宝唯一用户号
	 */
	userId,
	/**
	 * 分账到银行账户的银行编号。目前暂时只支持分账到一个银行编号。
	 */
	bankIndex,
	/**
	 * 分账到门店对应的银行卡编号。
	 */
	storeId
}
