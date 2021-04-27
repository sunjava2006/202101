package com.wangrui.spring_base.bean;

public class Car {

	private String brand;
	private String SN;

	public Car() {
		
	}

	public Car(String brand, String SN) {
		System.out.println("-------Car 构造方法调用中------");
		this.brand = brand;
		this.SN = SN;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}



	@Override
	public String toString() {
		return "Car [brand=" + brand + ", SN=" + SN + "]";
	}

	public void run() {
		System.out.println("----------run----------");
	}
}
