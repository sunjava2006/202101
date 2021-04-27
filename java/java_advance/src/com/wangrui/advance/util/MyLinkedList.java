package com.wangrui.advance.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, MyQueue<E>, Serializable {

	private int size = 0;
	
	private Node<E> first; // 指向头节点
	private Node<E> last;  // 指向尾节点
	
	public void addFirst(E e) {
		if(size==0) { // 添加的是链表中第一个元素
			Node n = new Node(e, null, null);
			this.first = n;
			this.last = n;
		}else {
			Node n = new Node(e, null, this.first);
			this.first.previous = n;
			this.first = n;
		}
		size++;
	}
	
	public void addLast(E e) {
		if(size==0) { // 添加的是链表中第一个元素
			Node n = new Node(e, null, null);
			this.first = n;
			this.last = n;
		}else {
			Node n = new Node(e, last, null);
			this.last.next = n;
			this.last = n;
		}
		size++;
	}
	
	public Object clone() {
		Object o = null;
		return o;
	}
	
	boolean offerFirst(E e) {
		this.addFirst(e);
		return true;
	}
	
	boolean offerLast(E e) {
		this.addLast(e);
		return true;
	}

	public E peekFirst() {
		if(size==0) {
			return null;
		}else {
			return  this.first.value;
		}
		
	}
	
	public E peekLast() {
		if(size==0) {
			return null;
		}else {
			return  this.last.value;
		}
	}
	
	public E pollFirst() {
		if(size==0) {
			return null;
		}else if(size == 1) {
			E value = this.first.value;
			this.first = null;
			this.last = null;
			size--;
			return value;
			
		}else {
			E value = this.first.value;

			this.first = this.first.next;
			this.first.previous.next = null;
			this.first.previous = null;
			size--;
			return  value;
		}
		
	}
	
	public E pollLast() {
		if(size==0) {
			return null;
		}else if(size == 1) {
			E value = this.last.value;
			this.first = null;
			this.last = null;
			size--;
			return value;
			
		}else {
			E value = this.last.value;

			this.last = this.last.previous;
			this.last.next.previous = null;
			this.last.next = null;
			size--;
			return  value;
		}
	}
	
	public E removeFirst()  {
		if(size==0) {
			throw new NoSuchElementException();
		}else if(size == 1) {
			E value = this.first.value;
			this.first = null;
			this.last = null;
			size--;
			return value;
			
		}else {
			E value = this.first.value;

			this.first = this.first.next;
			this.first.previous.next = null;
			this.first.previous = null;
			size--;
			return  value;
		}
	}
	
	public E removeLast() {
		if(size==0) {
			throw new NoSuchElementException();
		}else if(size == 1) {
			E value = this.last.value;
			this.first = null;
			this.last = null;
			size--;
			return value;
			
		}else {
			E value = this.last.value;

			this.last = this.last.previous;
			this.last.next.previous = null;
			this.last.next = null;
			size--;
			return  value;
		}
	}
	
	@Override
	public boolean add(E e) {
		this.addLast(e);
		return true;
	}

	@Override
	public boolean addAll(MyCollection<? extends E> c) {
		for(E e : c) {
			this.add(e);
		}
		return true;
	}

	@Override
	public void clear() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	@Override
	public boolean contains(Object o) {
		boolean contain = false;
		
		Node currNode = this.first;
		while(currNode!=null) {
			if(currNode.next==null && o==null) {
				contain = true;
				break;
			}else {
				if(currNode.value.equals(o)) {
					contain = true;
					break;
				}
			}
			
			currNode = currNode.next;
		}
		
		return contain;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator iterator() {
		return new Iterator<E>() {
			
			private int cursor = 0;
			
			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public E next() {
				
				return MyLinkedList.this.get(cursor++);
			}
			
			@Override
			public void remove() {
				MyLinkedList.this.remove(--cursor);
			}
		};
	}

	@Override
	public boolean remove(Object o) {
        boolean contain = false;
		Node currNode = this.first;
		while(currNode!=null) {
			if(currNode.next==null && o==null) {
				contain = true;
				break;
			}else {
				if(currNode.value.equals(o)) {
					contain = true;
					break;
				}
			}
			
			currNode = currNode.next;
		}
		if(contain) {
			//删除currNode
			if(size==1) {
				this.first = null;
				this.last = null;
			}
			else if(this.first == currNode) {// 是头节点
				
				this.first = this.first.next;
				this.first.previous.next = null;
				this.first.previous = null;
			}
			else if(this.last == currNode) { // 是尾节点
				this.last = this.last.previous;
				this.last.next.previous = null;
				this.last.next = null;
			}else {//中间节点
				currNode.next.previous = currNode.previous;
				currNode.previous.next = currNode.next;
				currNode.previous = null;
				currNode.next = null;
			}
			
			size--;
		}
		
		
		return contain;
	}

	@Override
	public boolean removeAll(MyCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(MyCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
	
		return this.size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E element() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return peek();
	}

	@Override
	public E remove() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException();
		}
		return poll();
	}

	@Override
	public boolean offer(E e) throws IllegalStateException, ClassCastException, NullPointerException {
		this.add(e);
		return true;
	}

	@Override
	public E poll() {
		E e = null;
		if(size==0) {
			return null;
		}
		e = this.removeFirst();
		return e;
	}

	@Override
	public E peek() {
		if(size==0) {
			return null;
		}
		return this.get(0);
	}

	@Override
	public void add(int idx, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(int idx, MyCollection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(MyCollection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int idx) {
		E e = null;
		if(idx<0 || idx>=size) {
			throw new IndexOutOfBoundsException();
		}
		// next几次，用循环确定
		Node<E> currNode = this.first;
		for(int i=0; i<idx; i++) {
			currNode = currNode.next;
		}
		
		e = currNode.value;
		return e;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int idx) {
		if(idx<0 || idx>=size) {
			throw new IndexOutOfBoundsException();
		}
		
		E e = null;
		
		Node<E> currNode = this.first;
		for(int i=0;i<idx;i++) {
			currNode = currNode.next;
		}
		e = currNode.value;
		//删除currNode
		if(size==1) {
			this.first = null;
			this.last = null;
		}
		else if(this.first == currNode) {// 是头节点
			
			this.first = this.first.next;
			this.first.previous.next = null;
			this.first.previous = null;
		}
		else if(this.last == currNode) { // 是尾节点
			this.last = this.last.previous;
			this.last.next.previous = null;
			this.last.next = null;
		}else {//中间节点
			currNode.next.previous = currNode.previous;
			currNode.previous.next = currNode.next;
			currNode.previous = null;
			currNode.next = null;
		}
		
		size--;
		
		
		return e;
	}

	@Override
	public E set(int idx, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyList subList(int from, int to) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class Node<E>{
		private E value;
		private Node previous, next;
		
		private Node() {
			
		}

		public Node(E value, Node previous, Node next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}

	}
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) {
			String s = ite.next();
			System.out.println(s);
			if(s.equals("a")) {
				ite.remove();
			}
			
		}
		
		System.out.println("-----------------------------");
		ite = list.iterator();
		while(ite.hasNext()) {
			String s = ite.next();
			System.out.println(s);
		}
		
	}
}
