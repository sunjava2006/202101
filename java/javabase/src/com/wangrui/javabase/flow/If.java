package com.wangrui.javabase.flow;

public class If {

	public static void main(String[] args) {
		
		int ran = (int)(Math.random()*100);
		System.out.println(ran);
		
		if(0 != ran%2) {
			System.out.println("----------------");
			System.out.println("������");
			System.out.println("----------------");
		}else {
			System.out.println("----------------");
			System.out.println("��ż��");
			System.out.println("----------------");
		}
		
		
		
		if(ran>50) {
			System.out.println("����50��");
		}else {
			System.out.println("С�ڵ���50��");
		}
	
		System.out.println("======= end ========");
	}
}
