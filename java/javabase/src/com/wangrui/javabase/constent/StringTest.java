package com.wangrui.javabase.constent;

public class StringTest {

	public static void main(String[] args) {
		
		String s = "china";
		
		String s2 = "china";
		
		String s3 = new String("china2");
		
		
		System.out.println();
		System.out.println("china"=="china");
		
		System.out.println(s.toUpperCase());
		System.out.println(s);
		
		System.out.println(s = s.replace("ch", "CH"));
		System.out.println(s);
		
		
		
	
	}
}
