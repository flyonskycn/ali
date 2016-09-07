package com.flyonsky.ali;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.flyonsky.ali.data.EnumBillType;
import com.flyonsky.ali.data.EnumDateType;
import com.flyonsky.ali.data.EnumSceneType;
import com.flyonsky.ali.data.EnumSignType;
import com.flyonsky.ali.data.EnumTradeType;
import com.flyonsky.ali.data.pay.AppBizContent;
import com.flyonsky.ali.data.pay.BillBizContent;
import com.flyonsky.ali.data.pay.BillResData;
import com.flyonsky.ali.data.pay.CancelBizContent;
import com.flyonsky.ali.data.pay.CancelResData;
import com.flyonsky.ali.data.pay.CloseBizContent;
import com.flyonsky.ali.data.pay.CloseResData;
import com.flyonsky.ali.data.pay.CommonPayReq;
import com.flyonsky.ali.data.pay.PayBizContent;
import com.flyonsky.ali.data.pay.PayResData;
import com.flyonsky.ali.data.pay.PreCreateData;
import com.flyonsky.ali.data.pay.QueryBizContent;
import com.flyonsky.ali.data.pay.QueryRefundBizContent;
import com.flyonsky.ali.data.pay.QueryRefundResData;
import com.flyonsky.ali.data.pay.QueryResData;
import com.flyonsky.ali.data.pay.RefundBizContent;
import com.flyonsky.ali.data.pay.RefundResData;
import com.flyonsky.ali.data.pay.TradeBizContent;
import com.flyonsky.ali.data.pay.TradePayReq;
import com.flyonsky.ali.data.pay.WapBizContent;
import com.flyonsky.ali.data.pay.WapPayReq;

@Component
public class AlipayHandleImp extends AbstractHandle implements AlipayHandle{
	
	/**
	 * 统一收单线下交易预创建接口名称
	 */
	private static final String ALIPAY_TRADE_PRECREATE = "alipay.trade.precreate";
	
	/**
	 * 统一收单交易支付接口
	 */
	private static final String ALIPAY_TRADE_PAY = "alipay.trade.pay";
	
	/**
	 * 统一收单线下交易查询
	 */
	private static final String ALIPAY_TRADE_QUERY = "alipay.trade.query";
	
	/**
	 * 统一收单交易撤销接口
	 */
	private static final String ALIPAY_TRADE_CANCEL = "alipay.trade.cancel";
	
	/**
	 * 统一收单交易退款接口
	 */
	private static final String ALIPAY_TRADE_REFUND = "alipay.trade.refund";
	
	/**
	 * 统一收单交易关闭接口
	 */
	private static final String ALIPAY_TRADE_CLOSE = "alipay.trade.close";
	
	/**
	 * 手机网页支付
	 */
	private static final String ALIPAY_TRADE_WAP_PAY = "alipay.trade.wap.pay";
	
	/**
	 * 统一收单交易退款查询
	 */
	private static final String ALIPAY_TRADE_FASTPAY_REFUND_QUERY = "alipay.trade.fastpay.refund.query";
	
	/**
	 * 查询对账单下载地址
	 */
	private static final String ALIPAY_DATA_DATASERVICE_BILL_DOWNLOADURL_QUERY = "alipay.data.dataservice.bill.downloadurl.query";
	
	/**
	 * App支付
	 */
	private static final String ALIPAY_TRADE_APP_PAY = "alipay.trade.app.pay";
	
	/**
	 * 支付宝HTTPS请求地址
	 */
	@Value("${alipay.gate}")
	private String alipayGate;

	@Override
	public PreCreateData preCreate(String appid, String privateKey, String alipayPublicKey, TradePayReq req) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(req);
		req.setAppId(appid);
		req.setSignType(EnumSignType.RSA.toString());
		req.setMethod(ALIPAY_TRADE_PRECREATE);
		
		String sign = AlipayUtil.rsaSign(req, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		req.setSign(sign);
		
		PreCreateData receive = null;
		if(req.verify()){
			receive = this.checkPost(this.getAlipayGate(),
					req,
					PreCreateData.class,
					alipayPublicKey);
		}
		
		return receive;
	}

	@Override
	public PreCreateData preCreate(String appid, String privateKey, String alipayPublicKey, String outTradeNo,
			double totalAmount, String subject, String notifyUrl) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(outTradeNo);
		Assert.isTrue(totalAmount > 0);
		Assert.notNull(subject);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_PRECREATE, notifyUrl);
		
		TradeBizContent content = new TradeBizContent();
		content.setOutTradeNo(outTradeNo);
		content.setTotalAmount(totalAmount);
		content.setSubject(subject);
		
		data.setBizContent(content.toJson());
		
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		
		PreCreateData receive = null;
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(),
					data, 
					PreCreateData.class,
					alipayPublicKey);
		}
		
		return receive;
	}

	@Override
	public PayResData pay(String appid, String privateKey, String alipayPublicKey, TradePayReq req) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(req);
		
		req.setAppId(appid);
		req.setSignType(EnumSignType.RSA.toString());
		req.setMethod(ALIPAY_TRADE_PAY);
		
		// 签名
		String sign = AlipayUtil.rsaSign(req, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		req.setSign(sign);
		
		PayResData receive = null;
		if(req.verify()){
			receive = this.checkPost(this.getAlipayGate(), req, PayResData.class, alipayPublicKey);
		}
		
		return receive;
	}

	@Override
	public PayResData pay(String appid, String privateKey, String alipayPublicKey, String outTradeNo, double totalAmount,
			String subject, EnumSceneType sceneType, String authCode, String notifyUrl) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(outTradeNo);
		Assert.isTrue(totalAmount > 0);
		Assert.notNull(subject);
		Assert.notNull(sceneType);
		Assert.notNull(authCode);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_PAY, notifyUrl);
		
		PayBizContent content = new PayBizContent();
		content.setOutTradeNo(outTradeNo);
		content.setTotalAmount(totalAmount);
		content.setSubject(subject);
		content.setScene(sceneType.toString());
		content.setAuthCode(authCode);
		
		data.setBizContent(content.toJson());
		
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		
		PayResData receive = null;
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, PayResData.class, alipayPublicKey);
		}
		
		return receive;
	}

	@Override
	public QueryResData query(String appid, String privateKey, String alipayPublicKey, String tradeNo,
			EnumTradeType tradeType) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(tradeNo);
		Assert.notNull(tradeType);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_QUERY);
		QueryBizContent content = new QueryBizContent();
		
		switch(tradeType){
		case alipay:
			content.setTradeNo(tradeNo);
			break;
			default:
				content.setOutTradeNo(tradeNo);
				break;
		}
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		
		QueryResData receive = null;
		
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, QueryResData.class, alipayPublicKey);
		}
		
		return receive;
	}

	@Override
	public CancelResData cancel(String appid, String privateKey, String alipayPublicKey, String tradeNo,
			EnumTradeType tradeType) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(tradeNo);
		Assert.notNull(tradeType);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_CANCEL);
		CancelBizContent content = new CancelBizContent();
		
		switch(tradeType){
		case alipay:
			content.setTradeNo(tradeNo);
			break;
			default:
				content.setOutTradeNo(tradeNo);
				break;
		}
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		CancelResData receive = null;
		
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, CancelResData.class, alipayPublicKey);
		}
		return receive;
	}

	@Override
	public RefundResData refund(String appid, String privateKey, String alipayPublicKey, String tradeNo,
			EnumTradeType tradeType, double refundAmount, String reason) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(tradeNo);
		Assert.notNull(tradeType);
		Assert.isTrue(refundAmount > 0);
		
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_REFUND);
		RefundBizContent content = new RefundBizContent();
		content.setRefundAmount(refundAmount);
		content.setRefundReason(reason);
		
		switch(tradeType){
		case alipay:
			content.setTradeNo(tradeNo);
			break;
			default:
				content.setOutTradeNo(tradeNo);
				break;
		}
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		RefundResData receive = null;
		
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, RefundResData.class, alipayPublicKey);
		}
		return receive;
	}

	@Override
	public BillResData downloadBill(String appid, String privateKey, String alipayPublicKey, EnumBillType billType,
			Date date, EnumDateType dateType) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(billType);
		Assert.notNull(date);
		Assert.notNull(dateType);
		
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_DATA_DATASERVICE_BILL_DOWNLOADURL_QUERY);
		BillBizContent content = new BillBizContent();
		content.setBillType(billType.toString());
		SimpleDateFormat sf = null;
		switch(dateType){
		case month:
			sf = new SimpleDateFormat("yyyy-MM");
			break;
			default:
				sf = new SimpleDateFormat("yyyy-MM-dd");
				break;
		}
		content.setBillDate(sf.format(date));
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		BillResData receive = null;
		
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, BillResData.class, alipayPublicKey);
		}
		return receive;
	}

	@Override
	public QueryRefundResData queryRefund(String appid, String privateKey, String alipayPublicKey, String refundNo,
			String tradeNo, EnumTradeType tradeType) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(refundNo);
		Assert.notNull(tradeNo);
		Assert.notNull(tradeType);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_FASTPAY_REFUND_QUERY);
		QueryRefundBizContent content = new QueryRefundBizContent();
		content.setOutRequestNo(refundNo);
		switch(tradeType){
		case alipay:
			content.setTradeNo(tradeNo);
			break;
			default:
				content.setOutTradeNo(tradeNo);
				break;
		}
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		QueryRefundResData receive = null;
		
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, QueryRefundResData.class, alipayPublicKey);
		}
		return receive;
	}

	@Override
	public CloseResData close(String appid, String privateKey, String alipayPublicKey, String tradeNo,
			EnumTradeType tradeType, String operatorId) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(tradeNo);
		Assert.notNull(tradeType);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_CLOSE);
		CloseBizContent content = new CloseBizContent();
		content.setOperatorId(operatorId);
		switch(tradeType){
		case alipay:
			content.setTradeNo(tradeNo);
			break;
			default:
				content.setOutTradeNo(tradeNo);
				break;
		}
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		CloseResData receive = null;
		
		if(data.verify()){
			receive = this.checkPost(this.getAlipayGate(), data, CloseResData.class, alipayPublicKey);
		}
		return receive;
	}
	
	@Override
	public CommonPayReq wapPay(String appid, String privateKey, String alipayPublicKey, String outTradeNo,
			double totalAmount, String subject, String notifyUrl,
			String returnUrl) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(outTradeNo);
		Assert.isTrue(totalAmount > 0);
		Assert.notNull(subject);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_WAP_PAY, notifyUrl, returnUrl);
		WapBizContent content = new WapBizContent();
		content.setOutTradeNo(outTradeNo);
		content.setSubject(subject);
		content.setTotalAmount(totalAmount);
		content.setProductCode("QUICK_WAP_PAY");
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		
		return data;
	}

	@Override
	public CommonPayReq appPay(String appid, String privateKey, String alipayPublicKey, String outTradeNo,
			double totalAmount, String subject, String notifyUrl) {
		Assert.notNull(appid);
		Assert.notNull(privateKey);
		Assert.notNull(alipayPublicKey);
		Assert.notNull(outTradeNo);
		Assert.isTrue(totalAmount > 0);
		Assert.notNull(subject);
		
		CommonPayReq data = this.createPayReq(appid, ALIPAY_TRADE_APP_PAY, notifyUrl);
		
		AppBizContent content = new AppBizContent();
		content.setTotalAmount(totalAmount);
		content.setOutTradeNo(outTradeNo);
		content.setSubject(subject);
		content.setProductCode("QUICK_MSECURITY_PAY");
		
		data.setBizContent(content.toJson());
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		data.setSign(sign);
		
		return data;
	}
	
	/**
	 * 获取当前时间字符串,以yyyy-MM-dd HH:mm:ss格式
	 * @return
	 */
	protected String curTimestamp(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curtime = Calendar.getInstance().getTime();
		return sf.format(curtime);
	}
	
	/**
	 * 新建手机网页支付请求参数
	 * @param appid 支付宝appid
	 * @param method 接口名称
	 * @param notifyUrl 异步通知URL
	 * @param returnUrl 同步通知地址
	 * @return
	 */
	protected CommonPayReq createPayReq(String appid, String method, String notifyUrl, String returnUrl){
		WapPayReq data = new WapPayReq();
		data.setNotifyUrl(notifyUrl);
		data.setReturnUrl(returnUrl);
		this.initPayReq(data, appid, method);
		
		return data;
	}
	
	/**
	 * 新建其它支付相关请求参数
	 * @param appid 支付宝appid
	 * @param method 接口名称
	 * @return
	 */
	protected CommonPayReq createPayReq(String appid, String method){
		CommonPayReq data = new CommonPayReq();
		this.initPayReq(data, appid, method);
		return data;
	}
	
	/**
	 * 新建支付创建请求参数
	 * @param appid 支付宝appid
	 * @param method 接口名称
	 * @param notifyUrl 异步通知URL
	 * @return
	 */
	protected CommonPayReq createPayReq(String appid, String method, String notifyUrl){
		TradePayReq data = new TradePayReq();
		data.setNotifyUrl(notifyUrl);
		this.initPayReq(data, appid, method);
		
		return data;
	}
	
	/**
	 * 初始化请求的公共信息
	 * @param data 公共请求参数
	 * @param appid 支付宝appid
	 * @param method 接口名称
	 */
	private void initPayReq(CommonPayReq data, String appid, String method){
		data.setAppId(appid);
		data.setSignType(EnumSignType.RSA.toString());
		data.setMethod(method);
		data.setFormat(AlipayConstants.FORMAT_JSON);
		data.setCharset(AlipayConstants.CHARSET_UTF8);
		data.setTimestamp(this.curTimestamp());
		data.setVersion(AlipayConstants.VERSION);
	}

	/**
	 * 支付宝HTTPS请求地址
	 * @return
	 */
	public String getAlipayGate() {
		return alipayGate;
	}

	/**
	 * 支付宝HTTPS请求地址
	 * @param alipayGate
	 */
	public void setAlipayGate(String alipayGate) {
		this.alipayGate = alipayGate;
	}
}
