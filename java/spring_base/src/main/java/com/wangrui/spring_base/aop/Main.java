package com.wangrui.spring_base.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.spring_base.aop.jdkproxy.Service;
import com.wangrui.spring_base.aop.service.PrintService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app2.xml");
		PrintService ps = app.getBean(PrintService.class);
		
		ps.print();
		ps.receive();
		System.out.println(ps.getClass().getName());
		
		System.out.println("================================");
		Service service = app.getBean(Service.class);
		service.service();
		System.out.println(service.getClass().getName());
	}

}
