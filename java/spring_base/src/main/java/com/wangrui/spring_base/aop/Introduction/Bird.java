package com.wangrui.spring_base.aop.Introduction;

import org.springframework.stereotype.Component;

//@Component
public class Bird implements Flyable{

	@Override
	public void fly() {
		System.out.println("fly----------");
	}

}
