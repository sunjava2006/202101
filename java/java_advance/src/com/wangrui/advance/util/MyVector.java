package com.wangrui.advance.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MyVector<E> implements MyList<E>{

   private Object[] array ;
	
	private int size = 0;
	private int capacityIncrement = 16;
	
	public MyVector() {
		this(10);
	}
	
	public MyVector(int capacity) {
		this.array = new Object[capacity];
	}

	public MyVector(int capacity,
            int capacityIncrement) {
		this.array = new Object[capacity];
		this.capacityIncrement = capacityIncrement;
	}
	
	private synchronized void grow(int minCount) {
		if(this.array.length < this.size + minCount) {
			Object[] newArray = new Object[this.array.length + minCount+this.capacityIncrement];
			System.arraycopy(this.array, 0, newArray, 0, this.size);
			this.array = newArray;
		}
	}
	
	
	@Override
	public synchronized boolean add(E e) {
		this.grow(1);
		this.array[this.size++] = e;
		return true;
	}

	@Override
	public synchronized boolean addAll(MyCollection<? extends E> c) {
		this.grow(c.size());
		for(E e : c) {
			this.array[this.size++] = e;
		}
		return true;
	}

	@Override
	public synchronized void clear() {
		for(int i=0;i<this.size;i++) {
			this.array[i] = null;
		}
		
		size = 0;
	}

	@Override
	public synchronized boolean contains(Object o) {
		
		return this.indexOf(o) != -1;
	}

	@Override
	public synchronized boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public synchronized Iterator iterator() {
		return new Iterator<E>() {
			
			private int cursor = 0;

			@Override
			public boolean hasNext() {
				
				return cursor < MyVector.this.size;
			}

			@Override
			public E next() {
				return MyVector.this.get(cursor++);
			}
			
			@Override
			public void remove() {

				MyVector.this.remove(--cursor);
				
			}
		};
		
	}

	@Override
	public synchronized boolean remove(Object o) {
		boolean ok = false;
		int at = -1;
		if(o==null) {
			for(int i=0;i<this.size; i++) {
				if(this.array[i] == null){
					ok = true;
					at = i;
				}
			}
		}
		else {
			for(int i=0;i<this.size; i++) {
				if(o.equals(array[i])) {
					ok = true;
					at = i;
				}
			}
		}
		if(ok) {
			for(int i= at+1; i<size; i++) {
				this.array[i-1]  = array[i];
			}
			size--;
		}
		
		
		return ok;
	}

	@Override
	public synchronized boolean removeAll(MyCollection<?> c) {
		boolean rm = false;
		for(Object o : c) {
			if(this.remove(o)) {
				rm = true;
			}
		}
		return rm;
	}

	@Override
	public synchronized boolean retainAll(MyCollection<?> c) {
		boolean rm = false;
		Iterator<E> ite = this.iterator();
		while(ite.hasNext()) {
			E e = ite.next();
			if(!c.contains(e)) {
				ite.remove();
			}
		}
		return rm;
	}

	@Override
	public synchronized int size() {
		
		return this.size;
	}

	@Override
	public synchronized Object[] toArray() {
		Object[] a = new Object[size];
		for(int i=0; i<size; i++) {
			a[i] = array[i];
		}
		return a;
	}

	@Override
	public synchronized E[] toArray(E[] a) {
		for(int i=0; i<size; i++) {
			a[i] = (E) array[i];
		}
		return a;
	}

	@Override
	public synchronized void add(int idx, E e) {
		grow(1);
		for(int i = size-1; i>=idx; i--) {
			array[i+1] = array[i];
		}
		array[idx] = e;
		size++;
	}

	@Override
	public synchronized boolean addAll(int idx, MyCollection<? extends E> c) {
		grow(c.size());
		int offset = c.size();
		for(int i=size-1; i>=idx; i--) {
			array[i+offset]  = array[i];
		}
		int count = 0;
		for(E e : c) {
			array[idx+count++] = e;
		}
		size += offset;
		return true;
	}

	@Override
	public synchronized boolean containsAll(MyCollection<?> c) {
		boolean contain = true;
		for(Object o : c) { // 遍历c，判断c中元素是否在当前列表中。
			if(!this.contains(o)) {
				contain = false;
				break;
			}
		}
		return contain;
	}

	@Override
	public synchronized E get(int idx) {
		E e = null;
		e = (E) this.array[idx];
		return e;
	}

	@Override
	public synchronized int indexOf(Object o) {
		int idx = -1;
		
		if(o == null) {
			for(int i=0; i<this.size; i++) {
				if(this.array[i] == null) {
					idx = i;
					break;
				}
			}
		}else {
			for(int i=0; i<this.size; i++) {
				if(o.equals(this.array[i])) {
					idx = i;
					break;
				}
			}
		}
		
		return idx;
	}

	@Override
	public synchronized int lastIndexOf(Object o) {
        int idx = -1;
		
		if(o == null) {
			for(int i=this.size-1; i>=0; i--) {
				if(this.array[i] == null) {
					idx = i;
					break;
				}
			}
		}else {
			for(int i=size-1; i>=0; i--) {
				if(o.equals(this.array[i])) {
					idx = i;
					break;
				}
			}
		}
		
		return idx;
	}

	@Override
	public synchronized ListIterator<E> listIterator() {
		return new ListIterator<E>() {

			private int cursor = 0;
			
			@Override
			public void add(E e) {
				int c = cursor;
				MyVector.this.add(c, e);
			}

			@Override
			public boolean hasNext() {
				return this.cursor<size;
			}

			@Override
			public boolean hasPrevious() {
				return this.cursor>0;
			}

			@Override
			public E next() {
			   return MyVector.this.get(cursor++);
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public E previous() {
				return MyVector.this.get(--cursor);
			}

			@Override
			public int previousIndex() {
				
				return cursor-1;
			}

			@Override
			public void remove() {
				MyVector.this.remove(--cursor);
				
			}

			@Override
			public void set(E e) {
				MyVector.this.set((cursor-1), e);
				
			}
		};
	}

	@Override
	public synchronized ListIterator<E> listIterator(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized E remove(int idx) {
		E e = null;
		e = (E) this.array[idx];
		for(int i=idx+1;i<size;i++) {
			array[i-1] = array[i];
		}
		size--;
		return e;
	}

	@Override
	public synchronized E set(int idx, E e) {
		E o = (E) array[idx];
		array[idx] = e;
		return o;
	}

	@Override
	public synchronized MyList subList(int from, int to) {
		MyVector<E> list = new MyVector<>(to-from);
		for(int i=0;i<list.array.length; i++) {
		   list.array[i] = MyVector.this.array[from+i];	
		}
		return list;
	}
	
	@Override
	public synchronized String toString() {
		return Arrays.toString(this.array);
	}
	
	public int capacity() {
	    return array.length;	
	}
	
	public E elementAt(int index) {
		return this.get(index);
	}
	
	public void addElement(E e) {
	    this.add(e);	
	}
	
	public static void main(String[] args) {
		MyVector<String> list = new MyVector<>(3);
		
		list.add("java");
		list.add("js");
		list.add("c");
		list.add("C++");
		list.add("oracle");
		list.add("html");
		
		System.out.println(list.size());
		System.out.println(list.capacity());
		
		
//		Vector<String> v = new Vector<>(10, 0);
//		v.add("xx");
//		System.out.println(v.size());
//		System.out.println(v.capacity());
//		v.ensureCapacity(11);
//		System.out.println(v.capacity());
				

	}

}
