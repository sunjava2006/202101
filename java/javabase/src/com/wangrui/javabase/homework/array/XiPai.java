package com.wangrui.javabase.homework.array;

import java.util.Arrays;

public class XiPai {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8, 9, 10, 11, 12};
		
		int[] b = a.clone();
		
		int count = 0;
		do {
			count++;
			int[] l = Arrays.copyOfRange(a, 0, a.length/2);
			int[] r = Arrays.copyOfRange(a, a.length/2, a.length);
			
			for(int i=0; i<l.length; i+=1) {
				a[i*2] = l[i];
				a[i*2+1] = r[i];
			}
			System.out.println(Arrays.toString(a));
			
		}while(!Arrays.equals(a, b));
		
		System.out.println(count);
	}
}
