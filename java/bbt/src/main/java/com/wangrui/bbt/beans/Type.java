package com.wangrui.bbt.beans;

import java.io.Serializable;

public class Type implements Serializable{
	private Integer typeID;
	private String typeName;
	
	@Override
	public String toString() {
		return "Type [typeID=" + typeID + ", typeName=" + typeName + "]";
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(Integer typeID, String typeName) {
		super();
		this.typeID = typeID;
		this.typeName = typeName;
	}
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

}
