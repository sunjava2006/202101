package com.wangrui.javabase.array;

public class Array1 {

	public static void main(String[] args) {
		
		int[] a = new int[0];
		
		String[] stra = new String[3];
		
		System.out.println(a instanceof int[]);
		System.out.println(stra instanceof String[]);
		
		for(int i : a) {
			System.out.println(i);
		}
		
		for(String s : stra) {
			System.out.println(s);
		}
		
		boolean[] barr = new boolean[3];
		for(boolean b : barr) {
			System.out.println(b);
		}
		
		int[] arr ;
		arr = new int[] {10, 20, 30};
		
		for(int i : arr) {
			System.out.println(i);
		}
		
		int[] arr2 = {100, 200, 300};
		for(int i : arr2) {
			System.out.println(i);
		}
		
		System.out.println("============================");
		System.out.println(arr2[0]);
		arr2[0] = 900;
		System.out.println(arr2[0]);
//		System.out.println(arr2[3]);
		
		for (int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		
	}
}
