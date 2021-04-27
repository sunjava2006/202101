package com.wangrui.spring_base.bean;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class CarFactory implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		
		return new Car("VW", (int)(Math.random()*1000000000)+"");
	}

}
