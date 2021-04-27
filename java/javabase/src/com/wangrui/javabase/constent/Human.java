package com.wangrui.javabase.constent;

import java.util.Calendar;
import java.util.Date;

public class Human {

	private final Date birthDate;
	
	public Human(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public static void main(String[] args) {
		
		Date birthDate = new Date(1995-1900, 2, 15);
		
		Human h = new Human(birthDate);
		
		System.out.println(h.getBirthDate());
		
		//=======================================================
		
		Calendar c = Calendar.getInstance(); // π“¿˙»’¿˙
		c.set(Calendar.YEAR, 1995);
		c.set(Calendar.MONTH, 3);
		c.set(Calendar.DATE, 15);
		c.set(Calendar.HOUR, 11);
		c.set(Calendar.MINUTE, 30);
		
		Date date = c.getTime();
		long timeMillis = c.getTimeInMillis();
		System.out.println(timeMillis);
		System.out.println(date);
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		c.get(Calendar.MILLISECOND);
		
		//=======================================
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int d = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR);
		int mini = c.get(Calendar.MINUTE);
		
		String s = year+"-"+month+"-"+d+" "+hour+":"+mini;
		System.out.println(s);
		
	}
}
