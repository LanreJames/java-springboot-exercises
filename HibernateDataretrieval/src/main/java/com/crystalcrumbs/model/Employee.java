package com.crystalcrumbs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee {
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eName=" + eName + ", eCity=" + eCity + ", eAge=" + eAge + "]";
	}


	@Id
	private Integer eid;
	private String eName;
	
	@Transient
	private String eCity;
	private Integer eAge;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}


	public String geteCity() {
		return eCity;
	}


	public void seteCity(String eCity) {
		this.eCity = eCity;
	}


	public Integer geteAge() {
		return eAge;
	}


	public void seteAge(Integer eAge) {
		this.eAge = eAge;
	}
	

}
