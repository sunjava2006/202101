package com.wangrui.advance.util.gun;

public class Gun {

	private ���� dj;
	
	public void fire() {
		dj.pop().fire();
	}
	
	public void add(���� dj) {
		this.dj = dj;
	}
	
	public static void main(String[] args) {
		Gun gun = new Gun();
		���� dj = new ����();
		
		dj.push(new �ӵ�());
		dj.push(new �ӵ�());
		dj.push(new �ӵ�());
		dj.push(new �ӵ�());
		dj.push(new �ӵ�());
		
		gun.add(dj);
		
		gun.fire();
		gun.fire();
		
	}
}
