package com.wangrui.javabase.homework;

public class Ran {

	public static void main(String[] args) {
		
		for(int i=0; i<20; i++) {
			int ran = (int)Math.round(Math.random()*100);
			if(0 != ran%2) {
				continue;
			}
				
			System.out.println(ran);
		}
		
	}
}
