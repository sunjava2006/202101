package com.wangrui.javabase.homework.array;

import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		int[] a = new int[10];
		
		for(int i=0; i<a.length; i++) {
			int ran = (int)Math.round(Math.random()*100);
			a[i] = ran;
		}
		
		for(int i=0;i<a.length-1; i++) {
			boolean change = false;
			for(int j=0; j<a.length-1-i; j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					change = true;
				}
			}
			if(!change) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}
}
