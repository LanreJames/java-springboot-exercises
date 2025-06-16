package com.crystalcrumbs.model;

public class Alien {
	private Integer Id;
	
	private String name;
	
	private String city;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Alien(Integer id, String string, String string2) {
		super();
		Id = id;
		this.name = string;
		this.city = string2;
	}

	public Alien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Alien [Id=" + Id + ", name=" + name + ", city=" + city + "]";
	}
	
}
