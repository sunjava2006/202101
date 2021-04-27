package com.wangrui.advance.util.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.wangrui.advance.util.map.People;

public class SetTest {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(2);
		
		System.out.println(set.size());
		
		Set<People> peopleSet = new HashSet<>();
		
		peopleSet.add(new People());
		peopleSet.add(new People("001","wang","M", 22));
		peopleSet.add(new People("002", "Fang", "M", 2));
		
		System.out.println(peopleSet.size());
		
		for(Integer i : set) {
			System.out.println(i);
		}
		
		Objects.hashCode(1);
	}
}
