package com.in28minutes.rest.webservices.restful_web_services.versioning;

public class PersionV2 {
	
	private Name name;

	public PersionV2(Name name) {
		super();
		this.name = name;
	}

	public PersionV2(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersionV2 [name=" + name + "]";
	}
	

}
