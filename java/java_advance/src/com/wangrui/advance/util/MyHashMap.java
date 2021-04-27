package com.wangrui.advance.util;

import java.util.Arrays;

public class MyHashMap<K,V> implements MyMap<K,V>{

	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	
	private MyEntryNode[] table ;
	
	private int size;
	
	public MyHashMap() {
		this.table = new MyEntryNode[DEFAULT_INITIAL_CAPACITY];
	}
	
	private int hash(Object key) {
		return key==null? 0 : key.hashCode()%16;
	}
	
	public static class MyEntry<K,V> implements MyMap.Entry<K,V>{
		private K key;
		private V value;
		
		MyEntry(){}

		public MyEntry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}
	}
	
	private class MyEntryNode<K,V>{
		private MyEntry<K,V> entry;
		private MyEntryNode<K,V> previous, next;
		
		MyEntryNode() {
		}

		MyEntryNode(MyEntry<K, V> entry, MyEntryNode<K, V> previous,
				MyEntryNode<K, V> next) {
			super();
			this.entry = entry;
			this.previous = previous;
			this.next = next;
		}
		
		
	}
	
	
	@Override
	public void clear() {
		Arrays.fill(this.table, null);
		this.size = 0;
	}

	@Override
	public boolean containsKey(Object key) {
		boolean contain = false;
		int at = this.hash(key);
		MyEntryNode node = this.table[at];
		if(node != null) {
			// 遍历链表节点
			MyEntryNode<K,V> currNode = node;
			while(currNode!=null) {
				// 判断key是否相同
				if(key==null && currNode.entry.key==null || key.equals(currNode.entry.key)) {
					contain = true;
					break;
				}
				currNode = currNode.next;
			}
		}
		return contain;
	}

	@Override
	public boolean containsValue(Object value) {
		
		return this.values().contains(value);
	}

	@Override
	public V get(Object key) {
		V v = null;
		
		int at = this.hash(key);
		MyEntryNode<K, V> node = this.table[at];
		
		if(node != null) {
			MyEntryNode<K, V> currNode = node;
			while(currNode!=null) {
				if(key==null && currNode.entry.key==null || key.equals(currNode.entry.key)) {
					v = currNode.entry.value;
					break;
				}
				currNode = currNode.next;
			}
		}

		return v;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size==0;
	}

	@Override
	public V put(K key, V val) {
		V v = null;
		//  根据hash（散列）函数，确定该key所对应的存储位置。
		int at = this.hash(key);
		MyEntryNode<K, V> node = table[at];
		if(node == null) {
			MyEntry<K,V> entry = new MyEntry<>(key, val);
			MyEntryNode<K,V> n = new MyEntryNode<>(entry, null, null);
			this.table[at] = n;
			size++;
			
		}else {
			// 遍历链表，找key 相同的节点。
			MyEntryNode<K,V> currNode = node;
			boolean containKey = false;
			while(currNode != null) {
				if(key==null && currNode.entry.key==null) {
					v = currNode.entry.value;
					currNode.entry.value = val;
					containKey = true;
					break;
				}else {
					if(key.equals(currNode.entry.key)){
						v = currNode.entry.value;
						currNode.entry.value = val;
						containKey = true;
						break;
					}
				}
				currNode = currNode.next;
			} // end while
			
			if(!containKey) {
				MyEntry<K,V> entry = new MyEntry<>(key, val);
				MyEntryNode<K,V> n = new MyEntryNode<>(entry, null, null);
				
				this.table[at].previous = n;
				n.next = this.table[at];
				
				this.table[at] = n;
				size++;
			}
			
		}
		
		return v;
	}

	@Override
	public void putAll(MyMap<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object key) {
		V v = null;
		int at = this.hash(key);
		MyEntryNode node = this.table[at];
		if(node!=null) {
			MyEntryNode<K, V> currNode = node;
			while(currNode!=null) {
				if(key==null && currNode.entry.key==null || key.equals(currNode.entry.key)) {
					v = currNode.entry.value;
					
					if(currNode.previous==null && currNode.next==null) {// 是唯一节点
						this.table[at] = null;
					}else if(currNode.previous==null && currNode.next != null) {// 是头节点
						this.table[at] = currNode.next;
						this.table[at].previous.next = null;
						this.table[at].previous = null;
						currNode = null;
					}else if(currNode.previous != null && currNode.next == null) {// 尾节点
						currNode.previous.next = null;
						currNode.previous = null;
						currNode = null;
								
					}else { // 中间节点
						currNode.previous.next = currNode.next;
						currNode.next.previous = currNode.previous;
						currNode.previous = null;
						currNode.next = null;
						currNode = null;
					}
					size--;
					
					break;
				}
				currNode = currNode.next;
			}
		}
		return v;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public MyCollection<V> values() {
		MyList<V> list = new MyArrayList<>();
		
		for(MyEntryNode node : this.table) {
			if(node != null) {
				MyEntryNode<K, V> currNode = node;
				while(currNode != null) {
					list.add(currNode.entry.value);
					currNode = currNode.next;
				}
			}
		}
		
		return list;
	}

	
	public static void main(String[] args) {
		MyMap<Integer, String> map = new MyHashMap<Integer, String>();
		
		map.put(1, "java");
		map.put(2, "oracle");
		map.put(3, "js");
		map.put(4, "python");
		map.put(5, "c");
		map.put(6, "c++");
		System.out.println(map.put(17, "VB"));
		System.out.println(map.put(17, "VC"));
		
		System.out.println(map.put(null, null));
		System.out.println(map.put(null, "没有"));
		System.out.println(map.get(null));
		
		System.out.println("size"+map.size());
		System.out.println("======================================");
		map.remove(4);
		map.remove(1);
		map.remove(17);
		
		for(int i=1;i<=6;i++) {
			System.out.println(i+":"+map.get(i));
		}
		System.out.println("17:" + map.get(17));
		System.out.println("18:" + map.get(18));
		
		System.out.println("size"+map.size());
		
		System.out.println("===============================");
		for(String s: map.values()) {
			System.out.println(s);
		}
		
		System.out.println(map.containsValue("c"));
		System.out.println(map.containsKey(null));
	}
}
