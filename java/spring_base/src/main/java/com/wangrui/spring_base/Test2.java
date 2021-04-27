package com.wangrui.spring_base;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.wangrui.spring_base.bean2.Car;
import com.wangrui.spring_base.bean2.Human;
import com.wangrui.spring_base.bean2.Library;
import com.wangrui.spring_base.bean2.Service;

public class Test2 {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		
//		Car car = (Car) app.getBean("myCar");
////		
//		System.out.println(car);
////		car.run();
//		
//		
		Human h = (Human) app.getBean("human");
		System.out.println(h);
//		System.out.println(car == h.getMyCar());
//		
//		Library l = app.getBean(Library.class);
//		System.out.println(l.getBookNames().size());
//		for(String s :l.getBookNames()) {
//			System.out.println(s);
//		}
		
		Service s = app.getBean(Service.class);
	    s.service();
		app.destroy();
	}
}
