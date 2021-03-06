package com.wangrui.spring_base.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Human {

	
//	@Qualifier(value = "car")
	private Car myCar; // 自动织入，按类型注入。同类型对象有多个，按属性名。属性名不匹配又没有qualifier，报错。
	
	public Car getMyCar() {
		return myCar;
	}
	
	@Autowired(required = false)
	@Qualifier(value = "benze")
	public void setMyCar(Car car) {
		this.myCar = car;
	}

	@Override
	public String toString() {
		return "Human [car=" + myCar + "]";
	}
	
	
}
