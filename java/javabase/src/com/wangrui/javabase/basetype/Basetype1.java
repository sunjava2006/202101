package com.wangrui.javabase.basetype;

public class Basetype1 {
	
	public static void main(String[] args) {
		boolean a = true;
		if(a) {
			System.out.println("ok");
		}else {
			System.out.println("no ok");
		}
		
		char c = 65; //'A';
		System.out.println(c);
		
		byte b = 127;
		
		int i = 99999999;
		
		long l2 = 99999999L;
		
		float f =  3.14159000000001F;
		System.out.println(f);
		
		double d = 3.1415900000000000001;
		System.out.println(d);
		long l = 999999999999999999L;
		int i2 = (int) l;
		
		byte b2 = (byte) i2;
		
		long l3 = b2;
		
		//=================================
		float f2 = l;
		System.out.println(f2);
		
		float f3 = (float) d;
		
		f3 = 3.2F;
		f3 = 1.4F;
		
		final int fa = 90; // 常量，只能初始化1次。
		
//		fa = 80;
		
		int aaa ;
		aaa = 0;
		
		System.out.println(aaa);
	}
}
