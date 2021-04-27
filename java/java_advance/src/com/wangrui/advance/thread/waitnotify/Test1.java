package com.wangrui.advance.thread.waitnotify;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		
		Object o = new Object();
		
		
		Thread t = new Thread() {
			public void run() {
				try {
					synchronized (o) {
						o.wait();
						System.out.println("-----------------");
					}
					System.out.println("end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t.start();
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					synchronized (o) {
						o.wait();
						System.out.println("-----------------");
					}
					System.out.println("end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t2.start();
		
		Thread.sleep(1000);
//		t.interrupt();
		synchronized (o) {
			o.notify();
		}
		
		
		
		
	}
}
