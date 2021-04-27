package com.wangrui.advance.util;

public interface MyMap<K,V> {

	static interface Entry<K,V>{
		 
	}
	
	void clear();
	
	boolean containsKey(Object key);
	
	boolean containsValue(Object value);
	
	boolean equals(Object o);
	
	V get(Object key);
	
	int hashCode();
	
	boolean isEmpty();
	
	V put(K key, V val);
	
	void putAll(MyMap<? extends K, ? extends V> m);
	
	V remove(Object key);
	
	int size();
	
	MyCollection<V> values();
	
}
