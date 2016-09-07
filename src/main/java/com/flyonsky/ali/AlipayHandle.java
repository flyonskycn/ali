package com.flyonsky.ali;

import java.util.Date;

import com.flyonsky.ali.data.EnumBillType;
import com.flyonsky.ali.data.EnumDateType;
import com.flyonsky.ali.data.EnumSceneType;
import com.flyonsky.ali.data.EnumTradeType;
import com.flyonsky.ali.data.pay.BillResData;
import com.flyonsky.ali.data.pay.CancelResData;
import com.flyonsky.ali.data.pay.CloseResData;
import com.flyonsky.ali.data.pay.CommonPayReq;
import com.flyonsky.ali.data.pay.PayResData;
import com.flyonsky.ali.data.pay.PreCreateData;
import com.flyonsky.ali.data.pay.QueryRefundResData;
import com.flyonsky.ali.data.pay.QueryResData;
import com.flyonsky.ali.data.pay.RefundResData;
import com.flyonsky.ali.data.pay.TradePayReq;

/**
 * 支付宝支付相关接口
 * @author Administrator
 *
 */
public interface AlipayHandle {

	/**
	 * 统一收单线下交易预创建
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param req 支付交易预创建请求参数
	 * @return 统一收单线下交易预创建响应
	 */
	PreCreateData preCreate(String appid,
			String privateKey,
			String alipayPublicKey,
			TradePayReq req);
	
	/**
	 * 统一收单线下交易预创建
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param outTradeNo 订单ID
	 * @param totalAmount 订单金额
	 * @param subject 订单标题
	 * @param notifyUrl 可为空,支付宝服务器主动通知商户服务器里指定的页面http/https路径
	 * @return 统一收单线下交易预创建响应
	 */
	PreCreateData preCreate(String appid,
			String privateKey,
			String alipayPublicKey,
			String outTradeNo,
			double totalAmount,
			String subject,
			String notifyUrl);
	
	/**
	 * 统一收单交易支付接口
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param req 统一收单交易支付接口请求参数
	 * @return
	 */
	PayResData pay(String appid,
			String privateKey,
			String alipayPublicKey,
			TradePayReq req);
	
	/**
	 * 统一收单交易支付接口
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param outTradeNo 订单ID
	 * @param totalAmount 订单金额
	 * @param subject 订单标题
	 * @param sceneType 支付场景
	 * @param authCode 支付授权码
	 * @param notifyUrl 可为空,支付宝服务器主动通知商户服务器里指定的页面http/https路径
	 * @return
	 */
	PayResData pay(String appid,
			String privateKey,
			String alipayPublicKey,
			String outTradeNo,
			double totalAmount,
			String subject,
			EnumSceneType sceneType,
			String authCode,
			String notifyUrl);
	
	/**
	 * 统一收单线下交易查询
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param tradeNo 订单ID
	 * @param tradeType 订单类型
	 * @return
	 */
	QueryResData query(String appid,
			String privateKey,
			String alipayPublicKey,
			String tradeNo,
			EnumTradeType tradeType);
	
	/**
	 * 统一收单交易撤销接口
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param tradeNo 订单ID
	 * @param tradeType 订单类型
	 * @return
	 */
	CancelResData cancel(String appid,
			String privateKey,
			String alipayPublicKey,
			String tradeNo,
			EnumTradeType tradeType);
	
	/**
	 * 统一收单交易退款接口
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param tradeNo 订单ID
	 * @param tradeType 订单类型
	 * @param refundAmount 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	 * @param reason 退款原因
	 * @return
	 */
	RefundResData refund(String appid,
			String privateKey,
			String alipayPublicKey,
			String tradeNo,
			EnumTradeType tradeType,
			double refundAmount,
			String reason);
	
	/**
	 * 下载对帐单
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param billType 帐单类型
	 * @param date 帐单日期,日帐单必须为已结结束的一天,月帐单必须为已经束的一月
	 * @param dateType 日期类型
	 * @return
	 */
	BillResData downloadBill(String appid,
			String privateKey,
			String alipayPublicKey,
			EnumBillType billType,
			Date date,
			EnumDateType dateType);
	
	/**
	 * 查询退款单 
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param refundNo 退款单号
	 * @param tradeNo 订单ID
	 * @param tradeType 订单类型
	 * @return
	 */
	QueryRefundResData queryRefund(String appid,
			String privateKey,
			String alipayPublicKey,
			String refundNo,
			String tradeNo,
			EnumTradeType tradeType);
	
	/**
	 * 统一收单交易关闭接口
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param tradeNo 订单ID
	 * @param tradeType 订单类型
	 * @param operatorId 卖家端自定义的的操作员 ID
	 * @return
	 */
	CloseResData close(String appid,
			String privateKey,
			String alipayPublicKey,
			String tradeNo,
			EnumTradeType tradeType,
			String operatorId);
	
	/**
	 * 手机网页支付 
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param outTradeNo 订单ID
	 * @param totalAmount 订单总金额
	 * @param subject 商品的标题
	 * @param notifyUrl 支付宝服务器主动通知商户服务器里指定的页面http/https路径
	 * @param returnUrl HTTP/HTTPS开头字符串
	 * @return
	 */
	CommonPayReq wapPay(String appid,
			String privateKey,
			String alipayPublicKey,
			String outTradeNo,
			double totalAmount,
			String subject,
			String notifyUrl,
			String returnUrl);
	
	/**
	 * App支付
	 * @param appid 支付宝分配给开发者的应用ID
	 * @param privateKey 开发者的私钥
	 * @param alipayPublicKey 支付宝的公钥
	 * @param outTradeNo 订单ID
	 * @param totalAmount 订单总金额
	 * @param subject 商品的标题
	 * @param notifyUrl 支付宝服务器主动通知商户服务器里指定的页面http/https路径
	 * @return
	 */
	CommonPayReq appPay(String appid,
			String privateKey,
			String alipayPublicKey,
			String outTradeNo,
			double totalAmount,
			String subject,
			String notifyUrl);
}
