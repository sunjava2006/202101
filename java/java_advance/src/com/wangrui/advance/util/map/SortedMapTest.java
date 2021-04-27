package com.wangrui.advance.util.map;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {

	public static void main(String[] args) {
		
		Comparator<People> comparator = new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				
				return o1.getName().compareTo(o2.getName());
			}

			
		};
		
		SortedMap<People, Integer> smap = new TreeMap<>(comparator);
		
		People p = new People("01", "Wang", "M", 2);
		People p2 = new People("02", "Fang", "M", 5);
		People p3 = new People("03", "Li", "W", 12);
		People p4 = new People("04", "Tang", "W", 2);
		People p5 = new People("05", "Zhang", "M", 4);
		
		smap.put(p, 1);
		smap.put(p2, 2);
		smap.put(p3, 3);
		smap.put(p4, 4);
		smap.put(p5, 5);
		
		System.out.println(smap.keySet());
		System.out.println(smap.values());
	}
}
