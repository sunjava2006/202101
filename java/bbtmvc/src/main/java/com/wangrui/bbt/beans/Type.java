package com.wangrui.bbt.beans;

import java.io.Serializable;

public class Type implements Serializable{

	public Type(Integer typeID, String name) {
		super();
		this.typeID = typeID;
		this.name = name;
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer typeID;
	private String name;
	
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
