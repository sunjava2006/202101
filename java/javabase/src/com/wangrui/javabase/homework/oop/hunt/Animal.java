package com.wangrui.javabase.homework.oop.hunt;

public class Animal {

	private int lifeValue = 100;
	
	protected int getLifeValue() {
		return this.lifeValue;
	}
	
	protected void setLifeValue(int val) {
		lifeValue = val;
	}
	
	public void eat(Food food) {
		int p = food.power/3;
		this.setLifeValue(this.getLifeValue()+p);
	}
}
