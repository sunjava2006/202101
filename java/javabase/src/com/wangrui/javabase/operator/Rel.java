package com.wangrui.javabase.operator;

import com.wangrui.javabase.basetype.People;

public class Rel {

	public static void main(String[] args) {
		
		System.out.println(1!=3);
		
		int a  = -6;
		int b = 12;
		System.out.println(a>>>1);
	
		int c = a<b? 100: 20;
		System.out.println(c);
		
		
		Object s = "hello";
		System.out.println(s instanceof People);
		
	}
}
