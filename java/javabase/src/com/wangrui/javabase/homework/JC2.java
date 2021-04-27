package com.wangrui.javabase.homework;

public class JC2 {

	
	public static long jc(long i) {
		if(i>1) {
			return i*jc(i-1);// return 3* jc(2)  return 2* jc(1) ---> reurn 3 * jc(2)* jc(1)
		}
		return 1;
	}
	
	public static void main(String[] args) {
		long r = jc(3);
		System.out.println(r);
	}
}
