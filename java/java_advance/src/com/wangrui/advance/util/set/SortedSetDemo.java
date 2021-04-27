package com.wangrui.advance.util.set;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.wangrui.advance.util.map.People;

public class SortedSetDemo {

	public static void main(String[] args) {
		
		SortedSet<Integer> set = new TreeSet<>();
//		
//		set.add(20);
//		set.add(2);
//		set.add(4);
//		set.add(1);
//		set.add(-1);
//		
//		for(Integer i : set) {
//			System.out.print(i + ",");
//		}
//		
//		System.out.println();
//		
		SortedSet<String> sset = new TreeSet<>();
//		sset.add("china");
//		sset.add("java");
//		sset.add("oracle");
//		sset.add("objc");
//
//		for(String s: sset){
//			System.out.print(s + ",");
//		}
//		System.out.println();
//		System.out.println(set.first());
//		System.out.println(set.last());
//		System.out.println(set.headSet(4));
//		System.out.println(set.tailSet(3));
//		System.out.println(set.subSet(0, 14));
		
		
		SortedSet<People> pset = new TreeSet<>();
		
		People p = new People("01", "wang", "M", 2);
		People p2 = new People("02", "Fang", "M", 5);
		People p3 = new People("03", "Li", "W", 12);
		People p4 = new People("04", "Tang", "W", 2);
		People p5 = new People("05", "Zhang", "M", 4);
		
		pset.add(p);
		pset.add(p2);
		pset.add(p3);
		pset.add(p4);
		pset.add(p5);
		
		System.out.println(p.equals(p2));
		
		for(People i: pset) {
			System.out.println(i);
		}
		
		//===========================================================
		
		Comparator<People> comparator = new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				
				return o1.getName().compareTo(o2.getName());
			}

			
		};
		
		SortedSet<People> pset2  = new TreeSet<>(comparator);
		pset2.add(p);
		pset2.add(p2);
		pset2.add(p3);
		pset2.add(p4);
		pset2.add(p5);
		
		System.out.println(pset2);
	}

}
