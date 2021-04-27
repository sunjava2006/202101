package com.wangrui.javabase.homework.interfaces;

public class Solder extends Material{
    public String model;
    public int force;
	
    public Solder(String name, String model, int force) {
    	super(name);
	    this.model = model;
	    this.force = force;
	}
    
    public void melt() {
    	System.out.println("∫∏Ãı»€ªØ");
    }
}
