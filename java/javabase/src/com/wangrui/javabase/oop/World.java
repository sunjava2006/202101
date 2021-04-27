package com.wangrui.javabase.oop;

public class World {

	static String sun = "太阳";
	
	static String a = new World().leaderName;
	
	String leaderName = null;
	
	static{
		sun = "全日";
	}
	
	{
		System.out.println();
	}
	
	public static void wind() {
		System.out.println("风吹啦。。。。。黄沙。。。。。");
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
		
		myWorld.sun = "日食";
		
		System.out.println(World.sun);
		
		World.wind();
	}
}
