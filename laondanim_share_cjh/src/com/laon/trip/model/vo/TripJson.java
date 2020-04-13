package com.laon.trip.model.vo;

import java.util.Arrays;

public class TripJson {
	private PersonJson[] name;

	public TripJson() {
		// TODO Auto-generated constructor stub
	}

	public TripJson(PersonJson[] list) {
		super();
		this.name = list;
	}

	public PersonJson[] getList() {
		return name;
	}

	public void setList(PersonJson[] list) {
		this.name = list;
	}

	@Override
	public String toString() {
		return "TripJson [name=" + Arrays.toString(name) + "]";
	}
	
	
	
	
	
}
