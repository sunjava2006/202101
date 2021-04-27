package com.wangrui.javabase.homework.oop.f6;

public class AirFactory {
	
	private static AirFactory f = new AirFactory();
	
	private AirFactory(){
		
	}
	
	public static AirFactory getFactory() {
		return f;
	}
	
	public Airplane6 create() {
		return new Airplane6Impl();
	}

}
