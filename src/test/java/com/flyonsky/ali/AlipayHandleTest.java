package com.flyonsky.ali;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.flyonsky.BaseSpringJUnit;
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

/**
 * 支付宝支付相关接口
 * @author Administrator
 *
 */
public class AlipayHandleTest extends BaseSpringJUnit{

	@Autowired
	private AlipayHandle alipayHandle;
	
	// 支付宝支付的appid
	@Value("${alipay.appid}")
	private String appid;
	
	// 支付私钥
	@Value("${alipay.private.key}")
	private String privateKey;
	
	// 支付宝平台公钥
	@Value("${alipay.platform.public.key}")
	private String alipayPublicKey;
	
	/**
	 * 统一收单线下交易预创建
	 */
	@Test
	public void testPreCreate(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		PreCreateData data = this.alipayHandle.preCreate(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				0.01,
				"测试沙箱",
				null);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
	
	/**
	 * 统一收单交易支付接口
	 */
	@Test
	public void testPay(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		
		PayResData data = this.alipayHandle.pay(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				0.01,
				"测试沙箱",
				EnumSceneType.bar_code,
				"28763443825664394",
				null);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
	
	/**
	 * 统一收单线下交易查询
	 */
	@Test
	public void testQuery(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		
		QueryResData data = this.alipayHandle.query(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				EnumTradeType.bussness);
		
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
	
	/**
	 * 统一收单交易撤销接口
	 */
	@Test
	public void testCancel(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		
		CancelResData data = this.alipayHandle.cancel(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				EnumTradeType.bussness);
		
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
	
	/**
	 * 统一收单交易退款接口
	 */
	@Test
	public void testRefund(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		
		RefundResData data = this.alipayHandle.refund(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				EnumTradeType.bussness,
				0.01,
				null);
		
		Assert.assertNotNull(data);
		Assert.assertEquals("ACQ.TRADE_NOT_EXIST", data.getSubCode());
		System.out.println(data.toJson());
	}
	
	/**
	 * 下载对帐单
	 */
	@Test
	public void testDownloadBill(){
		Date curTime = Calendar.getInstance().getTime();
		Date billTime = new Date(curTime.getTime() - 24*60*60*1000);
		BillResData data = this.alipayHandle.downloadBill(appid,
				privateKey,
				alipayPublicKey,
				EnumBillType.trade,
				billTime,
				EnumDateType.day);
		Assert.assertNotNull(data);
		System.out.println(data.toJson());
	}
	
	/**
	 * 查询退款单 
	 */
	@Test
	public void testQueryRefund(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		
		QueryRefundResData data = this.alipayHandle.queryRefund(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				outTradeNo,
				EnumTradeType.bussness);
		
		Assert.assertNotNull(data);
		Assert.assertEquals("ACQ.TRADE_NOT_EXIST", data.getSubCode());
		System.out.println(data.toJson());
	}
	
	/**
	 * 统一收单交易关闭接口
	 */
	@Test
	public void testClose(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		
		CloseResData data = this.alipayHandle.close(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				EnumTradeType.bussness,
				null);
		
		Assert.assertNotNull(data);
		Assert.assertEquals("ACQ.TRADE_NOT_EXIST", data.getSubCode());
		System.out.println(data.toJson());
	}
	
	/**
	 * 手机网页支付 
	 */
	@Test
	public void testWapPay(){
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String outTradeNo = sf.format(Calendar.getInstance().getTime());
		CommonPayReq data = this.alipayHandle.wapPay(appid,
				privateKey,
				alipayPublicKey,
				outTradeNo,
				0.01,
				"测试沙箱",
				null,
				null);
		Assert.assertNotNull(data);
	}
}
