package com.wangrui.javabase.homework;

public class FieBo {

	public static void main(String[] args) {
		
		int a = 1, b = 1;
		
		int sum = 0;
		sum = a+b;
		
		while(sum<=5000) {
			int c = a + b;
			a = b;
			b = c;
			sum += c;
			System.out.println(c);
			
		}
		System.out.println("sum: " + sum);
	}
}
