package com.wangrui.javabase.oop.inner;

public class Car {

	static String  brand = "QQ";
	
	public Engine engine = new Engine(); // �ⲿ������ڲ���ķ�ʽ�����һ����ͨ����һ����
	
	public void run() {
		Engine.a();
		this.engine.run(); // ʵ�����ڲ�������ٷ��������Ժͷ�����
	}
	
	
	public void provide() {
		
		{
			class Pump{
				void provide() {
					System.out.println("����");
				}
			}
			Pump p = new Pump();
			p.provide();
		}
		
		
		
	}
	
	public static class Engine{
		String brand = Car.brand; // �ڲ������ֱ�ӷ����ⲿ������ԡ�
		static int money  = 10000;
		private void run() {
			System.out.println("--------    run ---------------");
		}
		
		public static void a() {
			System.out.println("--------------");
		}
	}
	
	
}
