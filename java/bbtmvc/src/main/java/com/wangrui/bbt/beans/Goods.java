package com.wangrui.bbt.beans;

import java.io.Serializable;

public class Goods implements Serializable{

	private Integer goodsID;
	private Type type;
	private String goodsName;
	private String unit;
	private float price;
	private String photo;
	
	@Override
	public String toString() {
		return "Goods [goodsID=" + goodsID + ", type=" + type + ", goodsName=" + goodsName + ", unit=" + unit
				+ ", price=" + price + ", photo=" + photo + "]";
	}
	public Integer getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(Integer goodsID) {
		this.goodsID = goodsID;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(Integer goodsID, Type type, String goodsName, String unit, float price, String photo) {
		super();
		this.goodsID = goodsID;
		this.type = type;
		this.goodsName = goodsName;
		this.unit = unit;
		this.price = price;
		this.photo = photo;
	}
	
	
}
