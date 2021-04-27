package com.wangrui.advance.thread;

public class ThreadGroupTest {

	public static void main(String[] args) {
		
		Runnable target = new Runnable() {

			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println(t.getName()+":"+t.getThreadGroup().getName());
			}
			
		};
		
		ThreadGroup group = new ThreadGroup("组1");
		
		Thread t = new Thread(group, target, "线程1");
		Thread t2 = new Thread(group, target, "线程2");
		
		t.start();
		t2.start();
		
//		t.stop();
//		t2.stop();
		group.stop();
		
		
	}
}
