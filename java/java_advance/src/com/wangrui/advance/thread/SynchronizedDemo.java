package com.wangrui.advance.thread;

import java.util.Arrays;

public class SynchronizedDemo {

	int count = 0;
	int[] array = new int[20000];
	
	// 同步方法，同一时刻，该对象这个方法，只能被一个线程执行。
	public  void add(int id) { 
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
		try {
			synchronized (this) {
				array[count] = id;
				Thread.sleep(0,1);
				count++;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
    public synchronized  void remove() { 
		System.out.println("########################");
		try {
			if(count>0) {
				count--;
				Thread.sleep(1);
				array[count] = 0;
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("########################");
	}
	
	public boolean isDouble() {
		boolean is = true;
		for(int i=0; i<array.length; i++) {
			int count = 0;
			for(int j=0;j<array.length; j++) {
			   if(array[i]==array[j]) {
				   count += 1;
			   }
			}
			if(count != 2) {
				is = false;
				System.out.println(i + "出现：" + count);
			}
		}
		return is;
	}
	
	public boolean isZero() {
		boolean is = true;
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				is = false;
				break;
			}
		}
		return is;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		SynchronizedDemo syn = new SynchronizedDemo();
		
		Runnable r = new Runnable() {
			public void run() {
				for(int i=1; i<=10000; i++) {
					System.out.println("------" + i);
					syn.add(i);
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			public void run() {
				for(int i=1; i<=10000; i++) {
					System.out.println("========" + i);
					syn.remove();
				}
			}
		};
		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		t.start();
		t2.start();
		
//		Thread.sleep(5000);
		t.join();
		t2.join();
//		System.out.println("count" + syn.count);
//		System.out.println(syn.isZero());
		System.out.println(syn.isDouble());
	}
}
