package com.wangrui.advance.homework;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.HOUR, 19);
		
		System.out.println(c.getTime());
		

	}

}
