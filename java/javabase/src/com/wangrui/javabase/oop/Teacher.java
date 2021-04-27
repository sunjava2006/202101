package com.wangrui.javabase.oop;

public class Teacher extends People{

	public Object work() {
		return "教学成果";
	}
	
	public void teach() {
		System.out.println("教学中..................");
	}
}
