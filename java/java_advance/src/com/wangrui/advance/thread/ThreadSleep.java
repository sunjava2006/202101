package com.wangrui.advance.thread;

public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(()->{
			try {
				for(int i=0;i<10;i++) {
					System.out.println("----------------------");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("---------end-----------");
			}
			
		}) ;
		
		t.start();
		
		t.sleep(400);
//		t.interrupt(); //  ´ò¶ÏtÏß³Ì
		System.out.println("===============main end================");
	}
}
