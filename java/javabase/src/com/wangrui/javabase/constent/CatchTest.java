package com.wangrui.javabase.constent;

public class CatchTest {

	public static void main(String[] args) {
		
		Byte b = 3;
		
		
		Integer i = 127;
		Integer i2 = 127;
		
		System.out.println(i == i2);
		
		
		Long l = Long.valueOf(127L);  // ×°Ïä·½·¨
		Long l2 = 128L;
		
		System.out.println(l == l2);
		
		Float f = Float.valueOf(2.3F);
		
		Double d = Double.valueOf(3.4);
		
	}
}
