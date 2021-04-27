package com.wangrui.javabase.array;

import java.util.Arrays;

public class TestClone {

	public static void main(String[] args) {
		int[] a = new int[] {10, 20, 30, 40};
		
		int[] b = a.clone();
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		b[0] = 80;
		a[0] = 90;
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		
		People[] peopleArr = new People[2] ;
		
		People p1 = new People();
		p1.name = "Wang";
		
		People p2 = new People();
		p2.name = "Xie";
		
		peopleArr[0] = p1;
		peopleArr[1] = p2;
		
		System.out.println(Arrays.toString(peopleArr));
		
		People[] peopleArr2 = peopleArr.clone();
		System.out.println(Arrays.toString(peopleArr2));
		
		peopleArr[0].name = "Tang";
		peopleArr2[1].name = "Fang";
		System.out.println(Arrays.toString(peopleArr));
		System.out.println(Arrays.toString(peopleArr2));
		
		
	}
}
