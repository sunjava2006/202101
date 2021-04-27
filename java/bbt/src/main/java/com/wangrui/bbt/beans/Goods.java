package com.wangrui.bbt.beans;

import java.io.Serializable;

public class Goods implements Serializable{

	private Integer goodsID;
	private Type type;
	private String name;
	private String unit;
	private double price;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Goods(Integer goodsID, Type type, String name, String unit, double price) {
		super();
		this.goodsID = goodsID;
		this.type = type;
		this.name = name;
		this.unit = unit;
		this.price = price;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [goodsID=" + goodsID + ", type=" + type + ", name=" + name + ", unit=" + unit + ", price=" + price
				+ "]";
	}
	
	
	
}
