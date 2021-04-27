package com.wangrui.javabase.oop;

public class Country {
	
	public static void a() {
		System.out.println("================Country=a============");
	}

	String name = "ÖÐ¹ú";
	
	public static void main(String[] args) {
		Country c = new Nation();
		
		System.out.println(c.name);
		
		System.out.println(((Nation)c).name);
		
		Country.a();
		
		Nation.a();
	}
	
}

class Nation extends Country{
	String name = "China";

//	public static void a() {
//		System.out.println("---------------Nation a------------------");
//	}
}
