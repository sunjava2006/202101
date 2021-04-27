package com.wangrui.javabase;

import java.io.Serializable;

public class CheckonMachineImpl  extends Object implements CheckonMachine, Serializable{

	@Override
	public Checkon[] getCheckonInfo() {
		
		return new Checkon[]{new Checkon("li", 0), new Checkon("wang", 1)};
	}

}
