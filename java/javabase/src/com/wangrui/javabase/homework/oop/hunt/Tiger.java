package com.wangrui.javabase.homework.oop.hunt;

public class Tiger extends Animal{

	public void attack(Animal a) {
		System.out.println("�ϻ���������");
		a.setLifeValue(a.getLifeValue() - 50);
	}
}
