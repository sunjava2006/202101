package com.wangrui.advance.util.gun;

public class Gun {

	private µ¯¼Ð dj;
	
	public void fire() {
		dj.pop().fire();
	}
	
	public void add(µ¯¼Ð dj) {
		this.dj = dj;
	}
	
	public static void main(String[] args) {
		Gun gun = new Gun();
		µ¯¼Ð dj = new µ¯¼Ð();
		
		dj.push(new ×Óµ¯());
		dj.push(new ×Óµ¯());
		dj.push(new ×Óµ¯());
		dj.push(new ×Óµ¯());
		dj.push(new ×Óµ¯());
		
		gun.add(dj);
		
		gun.fire();
		gun.fire();
		
	}
}
