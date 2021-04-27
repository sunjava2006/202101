package com.wangrui.javabase.operator;

public class Logic {

	public static boolean a() {
		System.out.println("-----a-----");
		return true;
	}
	
	public static boolean b() {
		System.out.println("-----b-----");
		return false;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(a() || b());
	}
}
