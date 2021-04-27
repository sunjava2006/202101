package com.wangrui.javabase.homework.array;

import java.util.Arrays;

public class DuiJiaoXian {

	public static void main(String[] args) {
		
		int[][] a = new int[5][5];
		int v = 1;
		
		for(int i = 0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = v++;
			}
		}
		
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
		
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum +=a[i][i];
		}
		System.out.println("sum1 :" + sum);
		
		System.out.println("==================================");
		sum = 0;
		for(int i=0; i<a.length; i++) {
			int j = a[i].length-i-1;
				sum += a[i][j];
			
		}
		
		System.out.println("sum2: " + sum);
		
		
	}
}
