package com.wangrui.javabase.oop.inner;

public class Car {

	static String  brand = "QQ";
	
	public Engine engine = new Engine(); // 外部类访问内部类的方式与访问一个普通类是一样。
	
	public void run() {
		Engine.a();
		this.engine.run(); // 实例化内部类对象，再访问其属性和方法。
	}
	
	
	public void provide() {
		
		{
			class Pump{
				void provide() {
					System.out.println("供油");
				}
			}
			Pump p = new Pump();
			p.provide();
		}
		
		
		
	}
	
	public static class Engine{
		String brand = Car.brand; // 内部类可以直接访问外部类的属性。
		static int money  = 10000;
		private void run() {
			System.out.println("--------    run ---------------");
		}
		
		public static void a() {
			System.out.println("--------------");
		}
	}
	
	
}
