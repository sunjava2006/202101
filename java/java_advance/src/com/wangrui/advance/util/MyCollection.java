package com.wangrui.advance.util;

import java.util.Iterator;

public interface MyCollection<E> extends Iterable<E>{

	boolean add(E e);
	
	boolean addAll(MyCollection<? extends E> c);
	
	void clear();
	
	boolean contains(Object o);
	
	boolean containsAll(MyCollection<?> c);
	
	boolean equals(Object o);
	
	int hashCode();
	
	boolean isEmpty();
	
	Iterator iterator();
	
	boolean remove(Object o);
	
	boolean removeAll(MyCollection<?> c);
	
	boolean retainAll(MyCollection<?> c);
	
	int size();
	
	Object[] toArray();
	
	E[] toArray(E[] a);
}
