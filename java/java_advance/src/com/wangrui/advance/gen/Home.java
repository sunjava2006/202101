package com.wangrui.advance.gen;

public class Home<T> {

	T pet ;
	
	Home(T o){
		pet = o;
	}
	
	
	public static void main(String[] args) {
		Home<Dog> h = new Home<Dog>(new Dog());
		Dog o = h.pet;
		
		Home<Cat> h2 = new Home<Cat>(new Cat());
		Cat c = h2.pet;
		
	}
}
