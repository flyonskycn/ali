package com.flyonsky.ali.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 统一收单交易支付接口响应
 * @author Administrator
 *
 */
public class PayResDataTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"buyer_logon_id\":\"159****5620\","
				+ "\"buyer_pay_amount\":8.88,"
				+ "\"buyer_user_id\":\"2088101117955611\","
				+ "\"card_balance\":98.23,"
				+ "\"code\":\"10000\","
				+ "\"discount_goods_detail\":\"[{\\\"goods_id\\\":\\\"STANDARD1026181538\\\",\\\"goods_name\\\":\\\"雪碧\\\",\\\"discount_amount\\\":\\\"100.00\\\",\\\"voucher_id\\\":\\\"2015102600073002039000002D5O\\\"}]\","
				+ "\"fund_bill_list\":[{\"amount\":10,\"fund_channel\":\"ALIPAYACCOUNT\",\"real_amount\":11.21}],"
				+ "\"gmt_payment\":\"2014-11-27 15:45:57\","
				+ "\"invoice_amount\":12.50,"
				+ "\"msg\":\"Success\","
				+ "\"out_trade_no\":\"6823789339978248\","
				+ "\"point_amount\":8.12,"
				+ "\"receipt_amount\":\"88.88\","
				+ "\"store_name\":\"证大五道口店\","
				+ "\"total_amount\":120.88,"
				+ "\"trade_no\":\"2013112011001004330000121536\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		PayResData data = mapper.readValue(json, PayResData.class);
		
		Assert.assertNotNull(data);
		
		System.out.println(data.toJson());
	}
}
