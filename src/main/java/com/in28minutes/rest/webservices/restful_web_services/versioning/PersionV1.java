package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class PersionV1 {
	
	
	public String name;

	public PersionV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersionV1 [name=" + name + "]";
	}
	

}
