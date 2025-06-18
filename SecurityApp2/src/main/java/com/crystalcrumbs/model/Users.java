package com.crystalcrumbs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class Users {
	
	@Id
	private String name;
	
	private String password;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
