package com.wangrui.bbt.beans;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	public User() {
		
	}
	
	private Integer userID;
	private String regName;
	private String pwd;
	private String bankAccount;
	private String name;
	
	
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", regName=" + regName + ", pwd=" + pwd + ", bankAccount=" + bankAccount
				+ ", name=" + name + "]";
	}
	
	
}
