package com.wangrui.advance.util;

import java.util.NoSuchElementException;

public interface MyQueue<E> extends MyCollection<E>{

	// ������н���У����޴洢�ռ�ʱ����Ƹ�쳣��
	boolean add(E e)throws IllegalStateException,ClassCastException, NullPointerException;
	
	// ��ȡ����ͷ��Ԫ�أ�����ɾ����Ԫ�ء�������Ϊ��ʱ���׳��쳣��
	E element()throws NoSuchElementException;
	
	// ��ȡ����ͷ��Ԫ�أ���ɾ����Ԫ�ء�������Ϊ��ʱ���׳��쳣��
	E remove() throws NoSuchElementException;
	
	boolean offer(E e) throws IllegalStateException,ClassCastException, NullPointerException;
	
	// ��ȡ����ͷ��Ԫ�أ�ɾ����Ԫ�ء�������Ϊ��ʱ����null��
	E poll();
	
	// ��ȡ����ͷ��Ԫ�أ�����ɾ����Ԫ�ء�������Ϊ��ʱ����null��
	E peek();
	
}
