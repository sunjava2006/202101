package com.wangrui.javabase.homework.oop;

public class FamilyLi {

	public static String firstName = "Àè"; // 
	private String lastName;  // 
	
	FamilyLi(String lastName){
		this.lastName = lastName;
	}
	
	public String getName() {
		return this.firstName+this.lastName;
	}
	
	
	public static void main(String[] args) {
		FamilyLi p = new FamilyLi("°×");
		
		FamilyLi p2 = new FamilyLi("¿ý");
		
		FamilyLi p3 = new FamilyLi("Ïæ");
		
		System.out.println(p.getName());
		System.out.println(p2.getName());
		System.out.println(p3.getName());
		
		FamilyLi.firstName = "ÕÅÀè";
		
		System.out.println(p.getName());
		System.out.println(p2.getName());
		System.out.println(p3.getName());
	}
	
}
