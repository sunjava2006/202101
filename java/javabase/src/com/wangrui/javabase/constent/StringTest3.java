package com.wangrui.javabase.constent;

import java.util.Arrays;

public class StringTest3 {

	public static void main(String[] args) {
		
		String s = "中国人";
		
		String str = new String("HellO");
		
		char[] chars = {'H','i','!','!'};
		String str2 = new String(chars, 0, 3);
		System.out.println(str2);
		
		byte[] bytes = "我们要好好学习".getBytes();
		
		String str3 = new String(bytes);
		System.out.println(Arrays.toString(bytes));
	    System.out.println(str3);
	    
	    System.out.println(str.toUpperCase());
	    System.out.println(str.toLowerCase());
	    System.out.println(str.replace("H", "XXXX"));
	    System.out.println(str.indexOf((int)'e', 2));
	    System.out.println(str.indexOf("ll", 1));
	    System.out.println(str.lastIndexOf("O"));
	    
	    System.out.println(str.charAt(0));
	    System.out.println(str.toCharArray());
	    System.out.println(str.startsWith("He"));
	    System.out.println(str.endsWith("llO"));
	    System.out.println(str.contains("el"));
	    System.out.println(str.equals("Hello"));
	    System.out.println(str.equalsIgnoreCase("HeLLO"));
	    System.out.println(str.contentEquals("Hello"));
	    
	    }

}
