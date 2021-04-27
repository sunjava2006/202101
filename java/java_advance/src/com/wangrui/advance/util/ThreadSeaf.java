package com.wangrui.advance.util;

public class ThreadSeaf {

	public static void main(String[] args) throws InterruptedException {
		MyList<Integer> list = new MyLinkedList<>();//MyArrayList<>();//MyVector<>();
		
		Runnable task = ()->{
			for(int i=0;i<10000;i++) {
				list.add(i);
			}
		};
		
		Thread t = new Thread(task);
		Thread t2 = new Thread(task);
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(list.size());
	}
}
