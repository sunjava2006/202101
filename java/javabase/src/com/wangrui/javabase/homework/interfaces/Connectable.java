package com.wangrui.javabase.homework.interfaces;

public interface Connectable<T extends Material> {

	int force = 30; 
	
	void connect(T m);
}
