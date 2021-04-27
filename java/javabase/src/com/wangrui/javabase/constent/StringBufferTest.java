package com.wangrui.javabase.constent;

public class StringBufferTest {
	
	public static void main(String[] args) {
//	    StringBuffer sb = new StringBuffer(3);
	    StringBuilder sb = new StringBuilder();
	    
	    System.out.println(sb.capacity());
	    System.out.println(sb.length());
	    
	    sb.append("We like Java.");
	    sb.append("!");
	    sb.insert(0, "We like JS.");
	    sb.insert(7, "....");
	    sb.deleteCharAt(27);
	    sb.delete(7, 11);
	    sb.replace(0, 2, "Jack");
	    
	    System.out.println(sb);
	    
	    System.out.println(sb.capacity());
	    System.out.println(sb.length());
	}
}
