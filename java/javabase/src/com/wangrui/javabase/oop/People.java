package com.wangrui.javabase.oop;

public class People {

	public final String gender;
	public String name;
	public String birthDate;
	public float height;
	
	{
		System.out.println();
//		this.name = "Fang";
//		this.height = 90.3F;
//		this.gender = "2";
	}
	
	public People() {
		this.gender = "mail";
		System.out.println("People()");
	}
	
	public People(String gender) {
		this.gender = gender;
	}
	
	public People(String name, String gender, String birthDate, float h) {
		this.gender = gender;
		this.name = name;
		height = h;
		this.birthDate = birthDate;
	}
	
	public void eat(final String food) {
	    final int a ;
	    a = 90;
		String msg = this.name + "吃" + food;
		System.out.println(msg);
	}
	
	public void sleep() {
		System.out.println(this.name + "睡觉");
	}
	
	public void run() {
		System.out.println(this.name  + "跑步");
	}

	
	public Object work() {
		return "-----------------------工作成果";
	}
	

	
	
}
