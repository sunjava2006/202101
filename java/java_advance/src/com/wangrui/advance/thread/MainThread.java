package com.wangrui.advance.thread;

public class MainThread {

	public static void main(String[] args) {
		
		Thread main = Thread.currentThread(); // ��̬��������ȡ��ǰ����ִ�е��̡߳�
		System.out.println(main.getName() + "," + main.getId());
		
		Thread t1 = new Thread() {
			
			@Override
			public void run() { // �߳��壬���߳�ִ�е����ݡ�
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
		
		t1.start(); // �����̣߳�����JVM���̹߳滮������һ���µ��̣߳�ִ�и��̵߳�run������
		
		System.out.println("===============================================");
		
	    
		
		
	}
}
