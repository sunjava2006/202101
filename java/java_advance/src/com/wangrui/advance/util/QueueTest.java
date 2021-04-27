package com.wangrui.advance.util;

public class QueueTest {

	public static void main(String[] args) {
		MyQueue<String> queue = new MyLinkedList<>();
		
		queue.offer("java");
		queue.offer("js");
		queue.offer("oracle");
		queue.add("c");
		
//		System.out.println(queue.peek());
//		System.out.println(queue.peek());
//		System.out.println(queue.peek());
//		System.out.println(queue.element());
//		System.out.println(queue.element());
//		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		System.out.println(queue.poll());
		System.out.println(queue.remove());


	}

}
