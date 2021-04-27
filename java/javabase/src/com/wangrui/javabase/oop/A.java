package com.wangrui.javabase.oop;

public class A {

	int value = 90;
	
	public void change(int a) {
		System.out.println(a);
		a = 90;
		System.out.println(a);
	}
	
	
	public void change2(A a) {
		System.out.println(a.value);
		a.value = 0;
		System.out.println(a.value);
	}
	
	public void change3(A a) {
		System.out.println(a.value);
		a = null;
		System.out.println(a);
	}
	
	
	public void change4(A a) {
		System.out.println(a.value);
		a = new A();
		a.value = 1000;
		System.out.println(a.value);
	}
	
	public static void main(String[] args) {
		int value  = 10;
		
		A a = new A();
		
//		a.change(value);
//		System.out.println(value);
//		
//		
//		a.change2(a);
//		System.out.println(a.value);
//		
//		System.out.println("-------------------");
//		a.change3(a);
//		System.out.println(a.value);
		
		a.change4(a);
		System.out.println(a.value);
	}
}
