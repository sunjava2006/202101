package com.wangrui.javabase.oop;

public class B {

	public static String name;
	
	static {
		System.out.println("=============static============");
	    name = "Wang";	
	}
	
	{
		System.out.println("-------------block------------");
	}
	
	public static void main(String[] args) {
		System.out.println("------------ main --------------");
		
		B b = new B();
		B b2 = new B();
		
	}
}
