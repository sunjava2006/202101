package com.wangrui.javabase.homework.interfaces;

public class Factory {

	public static void main(String[] args) {
		
		Connectable<Solder> connector = new Weld<Solder>();
		Solder solder = new Solder("ÖÐÌ¼¸Öº¸Ìõ", "J422", 42);
		
		connector.connect(solder);

	}

}
