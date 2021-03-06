package com.wangrui.bbt.beans;

import java.io.Serializable;

public class OrderDetail implements Serializable{

	private Integer detailID;
	private Order order;
	private Goods goods;
	private int count;
	private double amount;
	public Integer getDetailID() {
		return detailID;
	}
	public void setDetailID(Integer detailID) {
		this.detailID = detailID;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(Integer detailID, Order order, Goods goods, int count, double amount) {
		super();
		this.detailID = detailID;
		this.order = order;
		this.goods = goods;
		this.count = count;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrderDetail [detailID=" + detailID + ", order=" + order + ", goods=" + goods + ", count=" + count
				+ ", amount=" + amount + "]";
	}
	
	
}
