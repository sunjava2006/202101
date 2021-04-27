package com.wangrui.advance.thread;

public class StateTest {

	public static void main(String[] args) throws InterruptedException {
		
		String msg = "hello";
		
		
		Runnable task = new Runnable() {
            public void run() {
            	synchronized (msg) {
            		System.out.println(msg);
				}
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t = new Thread(task) ;
		
		Thread daemon = new Thread() {
			public void run() {
				try {
					while(true) {
						System.out.println(t.getState());
//					    Thread.sleep(1);
					}
				} catch (Exception e) {
					
				}
				
				
			}
		};
		daemon.setDaemon(true);
		
		
		
		daemon.start();
		
		Thread.sleep(2000);
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (msg) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t2.start();
		t.start();
	}

}
