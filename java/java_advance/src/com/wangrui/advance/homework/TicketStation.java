package com.wangrui.advance.homework;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class TicketStation {

	private Ticket[] ticketList = new Ticket[10];
	private int count = this.ticketList.length;
	
	public TicketStation() {
		for(int i=0; i<ticketList.length; i++) {
			this.ticketList[i] = new Ticket(i+1);
		}
	}
	
	public  Ticket[] sell(int count) {
		Ticket[] t = null;
		synchronized(this.ticketList) {
			if(this.count >= count) {
				t = Arrays.copyOfRange(this.ticketList, this.count-count, this.count);
				for(int i= this.count-count; i<this.count; i++) {
					this.ticketList[i] = null;
				}
				this.count-=count;
		    }
		}
		
		
		return t;
	}
	
	public static void main(String[] args) throws InterruptedException {
		TicketStation stn = new TicketStation();
	
		Thread t = new Thread(new Task(stn, 1));
		Thread t2 = new Thread(new Task(stn, 2));
		Thread t3 = new Thread(new Task(stn, 3));
		
		t.start();
		t2.start();
		t3.start();
		
		Thread t4 = new Thread(new Task(stn, 1));
		Thread t5 = new Thread(new Task(stn, 2));
		Thread t6 = new Thread(new Task(stn, 3));
		
		t4.start();
		t5.start();
		//t6.start();
		
		t.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		//t6.join();
		
		System.out.println(Arrays.toString(stn.ticketList));
		
		
	}

}


class Task implements Runnable{
	TicketStation stn;
	int count;
	
//	static CyclicBarrier barrier = new CyclicBarrier(3); // 可反复用的。
	static CountDownLatch latch = new CountDownLatch(3); // 一次性的
	
	Task(TicketStation stn, int count){
		this.stn = stn;
		this.count = count;
	}

	@Override
	public void run() {
		try {
//			this.barrier.await(); // 等待
			System.out.println("----------------------");
			latch.countDown();
			
			latch.await();
			System.out.println("=======================");
			Ticket[] get = stn.sell(this.count);
			System.out.println(Thread.currentThread().getName() + ":"+ Arrays.toString(get));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}