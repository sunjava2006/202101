package com.wangrui.javabase.homework.oop;

public class Main {

	public static void main(String[] args) {
		Human h = new Actor("��", "���ӿ�", 22, "��С��ͯ", "�����ӳ�");
		
		h.dance();
		h.sing();
		
		((Actor)h).sumba();
		Actor a = (Actor) h;
		a.drive();
	}
}
