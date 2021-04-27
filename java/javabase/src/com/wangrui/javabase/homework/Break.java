package com.wangrui.javabase.homework;

public class Break {

	public static void main(String[] args) {
		
		a: for(int i=1; i<=9; i++) {
			b: for(int j=1;j<=i;j++) {
				System.out.print("*");
				if(j%3 == 0) {
					break a;
				}
			}
			System.out.println();
		}
		
	}
}
