package com.wangrui.advance.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<E> implements MyList<E>, Serializable{

	private Object[] array ;
	
	private int size = 0;
	
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(int capacity) {
		this.array = new Object[capacity];
	}

	private void grow(int minCount) {
		if(this.array.length < this.size + minCount) {
			Object[] newArray = new Object[this.array.length + minCount];
			System.arraycopy(this.array, 0, newArray, 0, this.size);
			this.array = newArray;
		}
	}
	
	
	@Override
	public boolean add(E e) {
		this.grow(1);
		this.array[this.size++] = e;
		return true;
	}

	@Override
	public boolean addAll(MyCollection<? extends E> c) {
		this.grow(c.size());
		for(E e : c) {
			this.array[this.size++] = e;
		}
		return true;
	}

	@Override
	public void clear() {
		for(int i=0;i<this.size;i++) {
			this.array[i] = null;
		}
		
		size = 0;
	}

	@Override
	public boolean contains(Object o) {
		
		return this.indexOf(o) != -1;
	}

	@Override
	public boolean isEmpty() {
		return this.size==0;
	}

	@Override
	public Iterator iterator() {
		return new Iterator<E>() {
			
			private int cursor = 0;

			@Override
			public boolean hasNext() {
				
				return cursor < MyArrayList.this.size;
			}

			@Override
			public E next() {
				return MyArrayList.this.get(cursor++);
			}
			
			@Override
			public void remove() {

				MyArrayList.this.remove(--cursor);
				
			}
		};
		
	}

	@Override
	public boolean remove(Object o) {
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
	public boolean removeAll(MyCollection<?> c) {
		boolean rm = false;
		for(Object o : c) {
			if(this.remove(o)) {
				rm = true;
			}
		}
		return rm;
	}

	@Override
	public boolean retainAll(MyCollection<?> c) {
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
	public int size() {
		
		return this.size;
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[size];
		for(int i=0; i<size; i++) {
			a[i] = array[i];
		}
		return a;
	}

	@Override
	public E[] toArray(E[] a) {
		for(int i=0; i<size; i++) {
			a[i] = (E) array[i];
		}
		return a;
	}

	@Override
	public void add(int idx, E e) {
		grow(1);
		for(int i = size-1; i>=idx; i--) {
			array[i+1] = array[i];
		}
		array[idx] = e;
		size++;
	}

	@Override
	public boolean addAll(int idx, MyCollection<? extends E> c) {
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
	public boolean containsAll(MyCollection<?> c) {
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
	public E get(int idx) {
		E e = null;
		e = (E) this.array[idx];
		return e;
	}

	@Override
	public int indexOf(Object o) {
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
	public int lastIndexOf(Object o) {
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
	public ListIterator<E> listIterator() {
		return new ListIterator<E>() {

			private int cursor = 0;
			
			@Override
			public void add(E e) {
				int c = cursor;
				MyArrayList.this.add(c, e);
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
			   return MyArrayList.this.get(cursor++);
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public E previous() {
				return MyArrayList.this.get(--cursor);
			}

			@Override
			public int previousIndex() {
				
				return cursor-1;
			}

			@Override
			public void remove() {
				MyArrayList.this.remove(--cursor);
				
			}

			@Override
			public void set(E e) {
				MyArrayList.this.set((cursor-1), e);
				
			}
		};
	}

	@Override
	public ListIterator<E> listIterator(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int idx) {
		E e = null;
		e = (E) this.array[idx];
		for(int i=idx+1;i<size;i++) {
			array[i-1] = array[i];
		}
		size--;
		return e;
	}

	@Override
	public E set(int idx, E e) {
		E o = (E) array[idx];
		array[idx] = e;
		return o;
	}

	@Override
	public MyList subList(int from, int to) {
		MyArrayList<E> list = new MyArrayList<>(to-from);
		for(int i=0;i<list.array.length; i++) {
		   list.array[i] = MyArrayList.this.array[from+i];	
		}
		return list;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.array);
	}
	
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>(3);
		
		list.add("java");
		list.add("js");
		list.add("c");
		list.add("C++");
		list.add("oracle");
		list.add("html");
		
//		list.remove("js");
//		list.remove("java");
//		list.remove("html");
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		for(String s : list) {
//			System.out.println(s);
//		}
		
        MyArrayList<String> list2 = new MyArrayList<>(3);
		
		list2.add("QC");
		
		list2.add("C#");
		list2.add("J#");
		
		
//		list.retainAll(list2);
//		
//		for(String s : list) {
//			System.out.println(s);
//		}
		
//		list.addAll(7, list2);
		
//		list.set(0, "JAVA");
//		
//		System.out.println(Arrays.toString(list.toArray()));
//	
//		System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
//		
//		System.out.println(list.lastIndexOf("java2"));
//		
//		MyList<String> l = list.subList(1, 4);
//		
//		System.out.println(l);
		
		ListIterator<String> ite = list.listIterator();
		while(ite.hasNext()){
			String s = ite.next();
			if("c".equals(s)) {
				ite.add("C--");
			}
			System.out.println(s);
		}
		System.out.println("============================");
		while(ite.hasPrevious()) {
			String s = ite.previous();
			System.out.println(s);
		}
	}

}
