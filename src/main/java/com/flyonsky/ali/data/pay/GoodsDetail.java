package com.flyonsky.ali.data.pay;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flyonsky.ali.data.AbstractData;
import com.flyonsky.ali.data.Required;

/**
 * 商品列表信息
 * @author Administrator
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsDetail extends AbstractData{

	// 商品的编号
	@Required
	@JsonProperty("goods_id")
	private String goodsId;
	
	// 支付宝定义的统一商品编号
	@JsonProperty("alipay_goods_id")
	private String alipayGoodsId;
	
	// 商品名称
	@Required
	@JsonProperty("goods_name")
	private String goodsName;
	
	// 商品数量
	@Required
	@JsonProperty("quantity")
	private int quantity;
	
	// 商品单价，单位为元
	@Required
	@JsonProperty("price")
	private double price;
	
	// 商品类目
	@JsonProperty("goods_category")
	private String goodsCategory;
	
	// 商品描述信息
	@JsonProperty("body")
	private String body;
	
	// 商品的展示地址
	@JsonProperty("show_url")
	private String showUrl;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getAlipayGoodsId() {
		return alipayGoodsId;
	}

	public void setAlipayGoodsId(String alipayGoodsId) {
		this.alipayGoodsId = alipayGoodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}
}
