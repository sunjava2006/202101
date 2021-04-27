package com.wangrui.blog.bean;

public class Type {

	private Integer typeID;
	private String type;
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Type(Integer typeID, String type) {
		super();
		this.typeID = typeID;
		this.type = type;
	}
	
	
}
