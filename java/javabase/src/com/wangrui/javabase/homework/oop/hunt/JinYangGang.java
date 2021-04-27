package com.wangrui.javabase.homework.oop.hunt;

public class JinYangGang {

	public static void main(String[] args) {
		
		Tiger tiger = new Tiger();
		Hunter hunter = new Hunter("ÎäËÉ");
		
		do {
			
			int ran = (int)(Math.random()*10);
			if(ran %2 == 0) {
				tiger.attack(hunter);
			}else {
				hunter.hunt(tiger);
			}
			
			Food food;
			if(ran<=5) {
				food = new Apple();
			}else {
				food = new Apple(20);
			}
			hunter.eat(food);
			
		}while(tiger.getLifeValue()>0 && hunter.getLifeValue()>0);
		
		if(hunter.getLifeValue()<=0) {
			System.out.println("ÁÔÈËÎşÉüÁË");
		}else {
			System.out.println("ÀÏ»¢ÎşÉüÁË");
		}
		
		
	}

}
