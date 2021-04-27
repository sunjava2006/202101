package com.wangrui.javabase.abs;

public class Test {

	public static void main(String[] args) {
		FlyControl fctrl = new FlyControlImple() ;
		
		fctrl.run();
		fctrl.fly();
		fctrl.roll();
	}

}
