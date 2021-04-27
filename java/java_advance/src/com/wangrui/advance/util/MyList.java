package com.wangrui.advance.util;

import java.util.ListIterator;

public interface MyList<E> extends MyCollection<E>{

	void add(int idx, E e);
	
	boolean addAll(int idx, MyCollection<? extends E> c);
	
	boolean containsAll(MyCollection<?> c);
	
	E get(int idx);
	
	int indexOf(Object o);
	
	int lastIndexOf(Object o);
	
	ListIterator<E> listIterator();
	
	ListIterator<E> listIterator(int idx);
	
	E remove(int idx);
	
	E set(int idx, E e);
	
	MyList subList(int from, int to);
}
