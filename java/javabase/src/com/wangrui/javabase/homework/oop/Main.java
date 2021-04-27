package com.wangrui.javabase.homework.oop;

public class Main {

	public static void main(String[] args) {
		Human h = new Actor("男", "卞子康", 22, "大小灵童", "美国队长");
		
		h.dance();
		h.sing();
		
		((Actor)h).sumba();
		Actor a = (Actor) h;
		a.drive();
	}
}
