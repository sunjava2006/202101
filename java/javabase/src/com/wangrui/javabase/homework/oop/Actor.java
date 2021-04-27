package com.wangrui.javabase.homework.oop;

public final class Actor extends Human {

	String alias;
	String role;
	
	public Actor(String gender) {
		super(gender);
	}
	
	public Actor(String gender, String name, int age, String alias, String role) {
		super(gender, name, age);
		this.alias = alias;
		this.role = role;
	}
	
	public void drive() {
		System.out.println(this.role + "�ڿ���.");
	}
	
	public void sumba() {
		System.out.println(this.role + "����sumba��");
	}
	
//	@Override
//	public void dance() {
//		this.sumba();
//	}
}

//class SuperStar extends Actor{
//	
//}
