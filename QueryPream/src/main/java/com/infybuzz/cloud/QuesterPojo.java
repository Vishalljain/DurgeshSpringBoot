package com.infybuzz.cloud;

public class QuesterPojo implements Comparable<QuesterPojo> {
	
	private String name; 
	private int qty;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public int compareTo(QuesterPojo object) {
		return this.getName().compareTo(object.getName());
	}
}
