package com.wangrui.spring_base.aop.Introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		Flyable h = (Flyable) app.getBean("human");
		h.fly();
		Human hh = (Human)h;
		
		hh.work();
		System.out.println(h);
				
	}
}
