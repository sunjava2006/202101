package com.wangrui.javabase.flow;

public class If {

	public static void main(String[] args) {
		
		int ran = (int)(Math.random()*100);
		System.out.println(ran);
		
		if(0 != ran%2) {
			System.out.println("----------------");
			System.out.println("是奇数");
			System.out.println("----------------");
		}else {
			System.out.println("----------------");
			System.out.println("是偶数");
			System.out.println("----------------");
		}
		
		
		
		if(ran>50) {
			System.out.println("大于50。");
		}else {
			System.out.println("小于等于50。");
		}
	
		System.out.println("======= end ========");
	}
}
