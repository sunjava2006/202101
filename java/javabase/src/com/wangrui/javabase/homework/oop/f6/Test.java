package com.wangrui.javabase.homework.oop.f6;

public class Test {

	public static void main(String[] args) {
			
//			AirplaneFactory factory=  new AirplaneFactory();
			Airplane6 plane = AirplaneFactory.create();
			
			plane.aiControl();
			plane.identify();
			plane.driver();
			
			AirFactory f = AirFactory.getFactory();
			Airplane6 p = f.create();
			
			
		}
}
