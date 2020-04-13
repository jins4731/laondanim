package com.laon.trip.model.vo;

public class PersonJson {
	private String name;
	private String age;
	
	public PersonJson() {
		// TODO Auto-generated constructor stub
	}

	
	
	public PersonJson(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "TripJson [name=" + name + ", age=" + age + "]";
	}
}
