package com.wangrui.javabase.homework.oop;

public class Human {

	final String gender;
	String name;
	int age;
	
	public Human(String gender){
		this(gender, null, 0);
	}
	
	public Human(String gender, String name, int age) {
		this.gender = gender;
		this.name = name;
		this.age = age;
	}
	
	public void sing() {
		System.out.println(this.name + "ÔÚ³ª¸è¡£");
	}
	
	public final void dance() {
		System.out.println(this.name + "ÔÚÌøÎè.");
	}

}
