package com.wangrui.advance.io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharEncodeDecode {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "hello.ÄãºÃ¡£";
		
		byte[] bytes = str.getBytes("gbk");
		System.out.println(Arrays.toString(bytes));
		
		bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		bytes = str.getBytes("utf-8");
		System.out.println(Arrays.toString(bytes));
	}
}
