package com.wangrui.javabase.homework.array;

import java.util.Arrays;

public class Soert {

	public static void main(String[] args) {

		int[] a = new int[10];

		for (int i = 0; i < a.length; i++) {
			int ran = (int) Math.round(Math.random() * 100);
			a[i] = ran;
		}
		
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length;j++) {
				if(a[i]>a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));

	}
}
