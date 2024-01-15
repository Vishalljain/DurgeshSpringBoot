package com.rest.min.filteringstatic;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Somebean {
	private String filed1;
	private String filed2;
	@JsonIgnore 
	private String filed3;
	public Somebean(String filed1, String filed2, String filed3) {
		super();
		this.filed1 = filed1;
		this.filed2 = filed2;
		this.filed3 = filed3;//i dont want to send this field as part of response
	}
	public String getFiled1() {
		return filed1;
	}
	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	public String getFiled3() {
		return filed3;
	}
	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}
	

}
