package com.wangrui.advance.util;

public class MyStack<E> extends MyVector<E>{

	public E push(E e) {
		this.addElement(e);
		return e;
	}

	public E pop() {
		return this.remove(this.size()-1);
	}
	
	public E peek() {
		return this.get(this.size()-1);
	}
	
	public boolean empty() {
		return this.isEmpty();
	}
	
	public int search(Object o) {
		return this.indexOf(o);
	}
	
	
}
