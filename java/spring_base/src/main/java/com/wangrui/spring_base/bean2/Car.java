package com.wangrui.spring_base.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "myCar")// 组件
@Scope(value = "prototype")
public class Car {

//	@Value(value = "QQ")
	@Autowired
	private String brand;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void run() {
		System.out.println("---------------run-----------");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
}
