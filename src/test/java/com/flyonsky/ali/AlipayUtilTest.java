package com.flyonsky.ali;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
import com.flyonsky.ali.data.EnumSignType;
import com.flyonsky.ali.data.pay.TradeBizContent;
import com.flyonsky.ali.data.pay.TradePayReq;

/**
 * 签名工具类测试
 * @author Administrator
 *
 */
public class AlipayUtilTest extends BaseSpringJUnit{

	// 支付宝支付的appid
	@Value("${alipay.appid}")
	private String appid;
	
	// 支付私钥
	@Value("${alipay.private.key}")
	private String privateKey;
	
	// 支付的公钥
	@Value("${alipay.public.key}")
	private String publicKey;
	
	// 支付宝平台公钥
	@Value("${alipay.platform.public.key}")
	private String alipayPublicKey;
	
	@Test
	public void testSign(){
		
		TradePayReq data = new TradePayReq();
		data.setAppId(appid);
		data.setSignType(EnumSignType.RSA.toString());
		data.setMethod("alipay.trade.precreate");
		data.setFormat(AlipayConstants.FORMAT_JSON);
		data.setCharset(AlipayConstants.CHARSET_UTF8);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date curtime = Calendar.getInstance().getTime();
		data.setTimestamp(sf.format(curtime));
		data.setVersion(AlipayConstants.VERSION);
	
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = f.format(Calendar.getInstance().getTime());
		
		TradeBizContent content = new TradeBizContent();
		content.setOutTradeNo(outTradeNo);
		content.setTotalAmount(0.01);
		content.setSubject("沙箱支付测试");
		
		data.setBizContent(content.toJson());
		
		String sign = AlipayUtil.rsaSign(data, privateKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		String signData = AlipayUtil.signValue(data);
		
		boolean flag = AlipayUtil.rsaCheck(signData, sign, publicKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		
		Assert.assertTrue(flag);
	}
	
	@Test
	public void testRsaCheck(){
		String data = "{\"code\":\"40004\",\"msg\":\"Business Failed\",\"sub_code\":\"ACQ.PAYMENT_AUTH_CODE_INVALID\",\"sub_msg\":\"支付失败，获取顾客账户信息失败，请顾客刷新付款码后重新收款，如再次收款失败，请联系管理员处理。[SOUNDWAVE_PARSER_FAIL]\",\"buyer_pay_amount\":\"0.00\",\"invoice_amount\":\"0.00\",\"out_trade_no\":\"20160901160434\",\"point_amount\":\"0.00\",\"receipt_amount\":\"0.00\"}";
		String sign = "E9cbpTCdX4hJx+FlrUhu5/VMpBLXTMIg6ynN4AO6MLIp9GPZlDgAV6KtFNRg8FpUUNVI5SjJbYMYXBluKPXviGI+pz90WC6UqUIDljjaDxj7W7npNLx4eUNy4V4KsnzrUnEnbUnZHEOH6dV3u2EAoJCxPHizs5IiJGaWm0NaYYg=";
		boolean flag = AlipayUtil.rsaCheck(data, sign, alipayPublicKey, AlipayConstants.CHARSET_UTF8, EnumSignType.RSA);
		Assert.assertTrue(flag);
	}
}