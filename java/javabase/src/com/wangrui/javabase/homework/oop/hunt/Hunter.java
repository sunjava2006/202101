package com.wangrui.javabase.homework.oop.hunt;

public class Hunter extends Human{
	
	public Hunter(String name) {
		super(name);
	}

	public void hunt(Animal a) {
		System.out.println("猎人向动物发起攻击");
		a.setLifeValue(a.getLifeValue()-10);
	}
}
