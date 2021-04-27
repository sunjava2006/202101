package com.wangrui.javabase.flow;

public class Switch {

	public static void main(String[] args) {
		
//		int ran  = (int)(Math.random()*10);
//		System.out.println(ran);
//		
//		switch (ran+"") {
//		case "0":
//			System.out.println(0);
////			break;
//		default:
//			System.out.println("´óÓÚ3");
////			break;
//		
//		case "1":
//			System.out.println(1);
////			break;
//		case "2":
//			System.out.println(2);
////			break;
//		case "3":
//			System.out.println(3);
////			break;
//		}
		
		
		Season s = Season.SPRING;
		
		switch (s) {
		case SPRING:
			System.out.println("spring");
			break;
		case SUMMER:
			System.out.println("summer");
			break;
		case AUTUMN:
			System.out.println("autumn");
			break;
		default:
			System.out.println("winter");
			break;
		}
	}
}
