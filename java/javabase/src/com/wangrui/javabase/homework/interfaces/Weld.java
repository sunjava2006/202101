package com.wangrui.javabase.homework.interfaces;

public class Weld<T extends Material> implements Connectable<T>{

	@Override
	public void connect(T m) {
		Solder s = (Solder) m;
		System.out.println("使用"+s.name+s.model+"进行焊接");
		s.melt();
		
	}

}
