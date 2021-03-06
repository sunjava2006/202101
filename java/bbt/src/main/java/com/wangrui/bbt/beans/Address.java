package com.wangrui.bbt.beans;

import java.io.Serializable;

public class Address implements Serializable{

	private Integer addressID;
	private Integer userID;
	private long phone;
	private String address;
	public Integer getAddressID() {
		return addressID;
	}
	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", userID=" + userID + ", phone=" + phone + ", address=" + address
				+ "]";
	}
	
	
}
