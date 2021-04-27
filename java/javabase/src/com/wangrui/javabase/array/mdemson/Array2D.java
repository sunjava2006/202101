package com.wangrui.javabase.array.mdemson;

import java.util.Arrays;

public class Array2D {

	public static void main(String[] args) {
		
		int[][] a = new int[3][2];
		
		for(int[] i : a) {
			System.out.println(Arrays.toString(i));
		}
		
		int[][] b = new int[3][];
		b[0] = new int[] {1,2};
		b[1] = new int[] {3,4,5};
		b[2] = new int[] {6};
		for(int[] i : b) {
			System.out.println(Arrays.toString(i));
		}
		
		int[][] c = new int[][]{{1},{1,2},{3,4,5}};
		for(int[] i : c) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println("==========================");
		char[][][] d = new char[2][3][];
		d[0][0] = new char[] {'a','g'};
		d[0][1] = new char[] {'b','h'};
		d[0][2] = new char[] {'c'};
		d[1][0] = new char[] {'d', 'j'};
		d[1][1] = new char[] {'e'};
		d[1][2] = new char[] {'f', 'k', 'L'};
		
		for(char[][] i : d) {
			for(char[] j : i) {
				System.out.println(Arrays.toString(j));
			}
		}
	}
}
