package com.wangrui.advance.homework;

public class Ticket {

	private int id;
	
	public Ticket(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + "]";
	}

	
	
}
