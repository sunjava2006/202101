package com.wangrui.javabase;

public class HR {

	private CheckonMachine machine ;
	
	public HR(CheckonMachine machine){
		this.machine = machine;
	}
	
	
	void printEmployeeCheckon() {
		
		Checkon[] list = this.machine.getCheckonInfo();
		for(Checkon c : list) {
			System.out.println(c.Name + ":" + c.status);
		}
	}
	
	public static void main(String[] args) {
		HR hr = new HR(new CheckonMachineImpl());
		hr.printEmployeeCheckon();
	}
}
