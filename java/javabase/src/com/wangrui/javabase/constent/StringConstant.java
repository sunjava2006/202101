package com.wangrui.javabase.constent;

import java.util.Arrays;

public class StringConstant {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		byte[] bytes = {104, 101, 108, 108, 111};
	     
		
		String s2= new String(bytes);
	    
		
		
		System.out.println("hello" == s2.intern());
	}
}
