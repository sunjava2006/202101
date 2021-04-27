package com.wangrui.spring_base.bean;

public class People {

	private Car car;

	public People() {
		
	}

	public People(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "People [car=" + car + "]";
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
