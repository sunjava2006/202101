package com.wangrui.advance.util.map;

public class TestHash {

	static final int hash(int code) {
        int h;
        return  (h = code) ^ (h >>> 16);
    }

	public static void main(String[] args) {
		for(int i=Integer.MIN_VALUE; i<=Integer.MAX_VALUE; i++) {
			System.out.println(hash(i));
		}
	}
}
