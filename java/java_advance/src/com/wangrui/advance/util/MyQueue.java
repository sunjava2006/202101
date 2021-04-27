package com.wangrui.advance.util;

import java.util.NoSuchElementException;

public interface MyQueue<E> extends MyCollection<E>{

	// 如果是有界队列，在无存储空间时，招聘异常。
	boolean add(E e)throws IllegalStateException,ClassCastException, NullPointerException;
	
	// 获取队列头的元素，但不删除该元素。当队列为空时，抛出异常。
	E element()throws NoSuchElementException;
	
	// 获取队列头的元素，并删除该元素。当队列为空时，抛出异常。
	E remove() throws NoSuchElementException;
	
	boolean offer(E e) throws IllegalStateException,ClassCastException, NullPointerException;
	
	// 获取队列头的元素，删除该元素。当队列为空时返回null。
	E poll();
	
	// 获取队列头的元素，但不删除该元素。当队列为空时返回null。
	E peek();
	
}
