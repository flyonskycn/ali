package com.flyonsky.ali.data.pay;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 统一收单线下交易预创建响应数据对象
 * @author Administrator
 *
 */
public class PreCreateDataTest {

	@Test
	public void testDeserialization() throws JsonParseException, JsonMappingException, IOException{
		String json = "{"
				+ "\"code\":\"10000\","
				+ "\"msg\":\"Success\","
				+ "\"out_trade_no\":\"6823789339978248\","
				+ "\"qr_code\":\"https://qr.alipay.com/bavh4wjlxf12tper3a\""
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		PreCreateData data = mapper.readValue(json, PreCreateData.class);
		Assert.assertNotNull(data);
	}
}
