package com.wangrui.javabase.test;

import com.wangrui.javabase.Checkon;
import com.wangrui.javabase.CheckonMachine;

public class Test {

	public static void main(String[] args) {
		int m = CheckonMachine.max;
		
		CheckonMachine cm = new CheckonMachine() {
			
			@Override
			public Checkon[] getCheckonInfo() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
