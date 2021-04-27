package com.wangrui.javabase.array;

import java.util.Arrays;

public class ForEachArray {

	public static void main(String[] args) {
		int[] a = {10, 20, 30, 40, 50};
		
		for(int i=0; i<a.length; i++) {
			System.out.println(i + ":" + a[i]);
		}
		
		for(int i : a) {
			System.out.println(i);
		}
		
		int[] b = new int[20];
		
		System.arraycopy(a, 0, b, 3, 3);
		System.out.println(Arrays.toString(b));
		
		int[] c = Arrays.copyOf(a, 5);
		System.out.println("c:"+Arrays.toString(c));
		
		int[] d = Arrays.copyOfRange(a, 2, 5);
		System.out.println(Arrays.toString(d));
		
		int[] e = a;
		System.out.println(a==e);
		System.out.println(c==a);
		
		System.out.println(a.equals(c));
		
		System.out.println(Arrays.equals(a, c));
		
		
		Arrays.fill(a, 76);
		
	}
}
