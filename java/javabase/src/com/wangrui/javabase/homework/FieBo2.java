package com.wangrui.javabase.homework;

public class FieBo2 {

	public static void main(String[] args) {
		int a = 1 , b = 1, sum = 0;
		sum = a+b;
		
		do {
			int c = a+b;
			a = b;
			b = c;
			sum += c;
			System.out.println(c);
		}while(sum <= 5000);
		
		System.out.println("sum : " + sum);
		
		
	}
	
}
