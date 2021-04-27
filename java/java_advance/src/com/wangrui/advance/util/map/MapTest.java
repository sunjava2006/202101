package com.wangrui.advance.util.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		
		map.put(1, "Java");
		map.put(2, "c");
		
		String s = map.get(1);
		System.out.println(s);
		
		System.out.println(map.get(2));
		
		for(Integer i : map.keySet()) {
			System.out.println(i);
		}
		
		for(String ss: map.values()) {
			System.out.println(ss);
		}
		
	}

}
