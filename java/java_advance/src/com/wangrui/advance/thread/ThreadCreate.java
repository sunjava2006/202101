package com.wangrui.advance.thread;

public class ThreadCreate {

	public static void main(String[] args) {
		
		Thread t = new Thread("��ӡ����߳�") {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		t.start();
		
		
		Runnable run1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("~~~~~~"+Thread.currentThread().getName());
			}
			
		};
		
		Runnable run2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("######"+Thread.currentThread().getName());
			}
			
		};
		
		Thread t2 = new Thread(run2, "�����߳�");
		t2.start();
		
	}

}
