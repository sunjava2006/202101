package com.wangrui.javabase.operator;

public class Operator {

	public static void main(String[] args) {
		
		int a = 1 + 1;
		System.out.println(a); // ±ê×¼Êä³ö
		
		int b = a - 2;
		System.out.println(b);
		
		int c = 2 * 4;
		System.out.println(c);
		
		int d = 3/2;
		System.out.println(d);
		
		System.out.println(4.0/2); // 
		
		int m = 23%5;
		System.out.println(m);
		
		int i = 1;
		
		System.out.println(++i);
		System.out.println(i);
		
		System.out.println("===========================================");
		
		int j = 1;
		j = --j;
		
		System.out.println(j);
		System.out.println(j);
		System.out.println(j);
		
		System.out.println("========================================");
		System.out.println(!true == false);
		System.out.println(!false == true);
		
		System.out.println(10>1 && 1==2);
		System.out.println("---------------------------------------------");
	}
}
