package com.wangrui.javabase.oop;

public class World {

	static String sun = "̫��";
	
	static String a = new World().leaderName;
	
	String leaderName = null;
	
	static{
		sun = "ȫ��";
	}
	
	{
		System.out.println();
	}
	
	public static void wind() {
		System.out.println("�紵��������������ɳ����������");
	}
	
	public static void about() {
		System.out.println(sun);
		World w = new World();
		System.out.println(w.leaderName);
	}
	
	public static void main(String[] args) {
		
		System.out.println(World.sun);
		
		World myWorld = new World();
		
//		System.out.println(myWorld.sun);
		
		myWorld.sun = "��ʳ";
		
		System.out.println(World.sun);
		
		World.wind();
	}
}
