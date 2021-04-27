package com.wangrui.advance.thread;

public class ValotileTest {
	
    static  boolean flag = true;
    
	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(()->{
			while(flag) {
				
			}
		});
		
		t.start();
		
		Thread.sleep(2000);
		flag = false;
		System.out.println("---------"+flag);
		System.out.println("'''''end'''''");
	}
}
