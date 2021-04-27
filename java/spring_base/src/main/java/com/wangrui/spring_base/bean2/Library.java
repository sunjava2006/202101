package com.wangrui.spring_base.bean2;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Library {

	@Autowired
	private Set<String> bookNames;

	public Set<String> getBookNames() {
		return bookNames;
	}

	public void setBookNames(Set<String> bookNames) {
		this.bookNames = bookNames;
	}

	@Override
	public String toString() {
		return "Library [bookNames=" + bookNames + "]";
	}
	
	
}
