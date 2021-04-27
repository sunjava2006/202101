package com.wangrui.spring_base.bean;

import java.util.List;

public class Library {

	private List<String> bookNameList;

	public List<String> getBookNameList() {
		return bookNameList;
	}

	public void setBookNameList(List<String> bookNameList) {
		this.bookNameList = bookNameList;
	}

	@Override
	public String toString() {
		return "Library [bookNameList=" + bookNameList + "]";
	}
	
	
}
