package com.wangrui.advance.thread;

public class DemonTest {

	public static void main(String[] args) throws InterruptedException {
	
		Thread main = Thread.currentThread();
		
		Runnable target = ()->{
			try {
//				while(true) {
					System.out.println("----------------" + main.getState());
					
//					Thread.sleep(1);
					
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		};
		
		Thread t = new Thread(target);
		t.setDaemon(true);
		t.start();
		
		Thread.sleep(1000);
		System.out.println("ÊØ»¤Ïß³Ì×´Ì¬£º"+t.getState());
		System.out.println("================ main end =================");
	}

}
