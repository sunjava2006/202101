package com.wangrui.javabase.homework.oop.f6;

public abstract  class AirplaneFactory {

	public static Airplane6 create() {
		return new Airplane6Impl();
	}
	
	
}
