package com.wangrui.bbt.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable{

	private Integer orderID;
	private Integer userID;
	private Date orderDate;
	private Integer status;
	private Address address; // 对一映射
	private List<OrderDetail> details;  //  对多映射
	
	
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}
	public Order() {
		
	}
	public Order(Integer orderID, Integer userID, Date orderDate, Integer status, Address address,
			List<OrderDetail> details) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.orderDate = orderDate;
		this.status = status;
		this.address = address;
		this.details = details;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", userID=" + userID + ", orderDate=" + orderDate + ", status=" + status
				+ ", address=" + address + ", details=" + details + "]";
	}
	
	
	
}
