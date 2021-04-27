package com.wangrui.javabase.homework.oop.f6;

public class Test2 {

	public static void main(String[] args) {
		
		Airplane6 air = new Airplane6() {

			@Override
			public void driver() {
				System.out.println("drive");
			}

			@Override
			public void aiControl() {
				
				System.out.println("ai");
			}

			@Override
			public void identify() {
				System.out.println("identify");
				
			}
			
		};
		
		air.driver();
		air.aiControl();
		air.identify();
		
		
		System.out.println(air.getClass().getName());
		System.out.println(air.getClass().getSuperclass().getName());
		
		
		
		Airplane6 air2 = new Airplane6Impl() {

			@Override
			public void aiControl() {
				System.out.println("ai");
			}

		};
		
		air2.driver();
		air2.aiControl();
		air2.identify();
		System.out.println(air2.getClass().getName());
		System.out.println(air2.getClass().getSuperclass().getName());
	}

}
