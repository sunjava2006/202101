package com.wangrui.javabase.homework.interfaces;

public class Weld<T extends Material> implements Connectable<T>{

	@Override
	public void connect(T m) {
		Solder s = (Solder) m;
		System.out.println("ʹ��"+s.name+s.model+"���к���");
		s.melt();
		
	}

}
