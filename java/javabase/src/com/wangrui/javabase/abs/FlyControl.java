package com.wangrui.javabase.abs;

public  abstract class FlyControl {

	public void run() {
		System.out.println("启动飞机引擎");
	}
	
	public void fly() {
		System.out.println("飞机起飞");
	}
	
	public abstract void roll();
	
}
