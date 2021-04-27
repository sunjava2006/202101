package com.example.demo.bean;

public class User {

	private String regName;
	private String pwd;
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
	@Override
	public String toString() {
		return "User [regName=" + regName + ", pwd=" + pwd + "]";
	}
	
	
}
