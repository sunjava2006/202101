package com.wangrui.advance.thread;

public class MainThread {

	public static void main(String[] args) {
		
		Thread main = Thread.currentThread(); // 静态方法，获取当前正在执行的线程。
		System.out.println(main.getName() + "," + main.getId());
		
		Thread t1 = new Thread() {
			
			@Override
			public void run() { // 线程体，是线程执行的内容。
				System.out.println("------------------------");
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+","+t.getId());
				System.out.println("------------------------");
				
				Thread t2 = new Thread() {
			    	@Override
			    	public void run() {
			    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
						Thread t = Thread.currentThread();
						System.out.println(t.getName()+","+t.getId());
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
			    	}
			    };
			    t2.start();
			}
		};
		
		t1.start(); // 启动线程，告诉JVM，线程规划器创建一个新的线程，执行该线程的run方法。
		
		System.out.println("===============================================");
		
	    
		
		
	}
}
