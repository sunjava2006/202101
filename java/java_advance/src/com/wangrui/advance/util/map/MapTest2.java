package com.wangrui.advance.util.map;


import java.util.*;

public class MapTest2 {

	public static void main(String[] args) {
		
//		Map<String, Integer> map = new HashMap<>(); 
		Map<String, Integer> map = new Hashtable<>();
		
		map.put("one", 1);
		map.put("two", 2);
		map.put("zero", null);
		map.put(null, 0);
		
		System.out.println(map.get("one"));
		System.out.println(map.get(null));
		
		
	}
	
}
