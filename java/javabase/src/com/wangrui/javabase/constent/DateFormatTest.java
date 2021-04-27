package com.wangrui.javabase.constent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {
		
		Date now = new Date();
		
		DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		String str = format.format(now);
	
		
		System.out.println(str);
		
		SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		
		str = smt.format(now);
		System.out.println(str);
		
		//====================================================
		try {
			str = "2021-03-23 10:56:59 ÐÇÆÚ¶þ";
			Date date = smt.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
