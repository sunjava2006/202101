package com.wangrui.javabase.oop;

public class Calculate {

	public static double sum(double a, double b) {
		double r = 0;
		r = a + b;
		return r;
	}
	
	
	public static void print(Object o) {
		if(o==null) {
			return;
		}
		System.out.println(o);
		return;
	}
	
	public static void main(String[] args) {
		
		double r = Calculate.sum(10D, 6.0);
		System.out.println(r);
		
	}
}
