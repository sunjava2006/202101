package com.wangrui.spring_base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring_base.bean.AbstractCarFactory;
import com.wangrui.spring_base.bean.Car;
import com.wangrui.spring_base.bean.Library;
import com.wangrui.spring_base.bean.People;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		Car car = (Car) app.getBean("car");
		
		car.run();
		System.out.println(car);
		
		People p = (People) app.getBean("people");
		System.out.println(p);
		
		
//		AbstractCarFactory factory =  app.getBean(AbstractCarFactory.class);
//		Car car = factory.create();
//		Car car2 = factory.create();
//		System.out.println(car == car2);
//		
//		System.out.println(car);
//		car.run();
//		System.out.println(factory.getClass().getName());
		
		System.out.println("==================================");
		
		Library lib = app.getBean(Library.class);
		System.out.println(lib);
		
	}
}
