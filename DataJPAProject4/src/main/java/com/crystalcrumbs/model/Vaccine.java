package com.crystalcrumbs.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaccine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String vaccineName;
	
	private String vaccinecompany;
	
	private Double cost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getVaccinecompany() {
		return vaccinecompany;
	}

	public void setVaccinecompany(String vaccinecompany) {
		this.vaccinecompany = vaccinecompany;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Vaccine(Integer id, String vaccineName, String vaccinecompany, Double cost) {
		super();
		this.id = id;
		this.vaccineName = vaccineName;
		this.vaccinecompany = vaccinecompany;
		this.cost = cost;
	}

	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vaccine [id=" + id + ", vaccineName=" + vaccineName + ", vaccinecompany=" + vaccinecompany + ", cost="
				+ cost + "]";
	}

	public Vaccine(String vaccineName, String vaccinecompany, Double cost) {
		super();
		this.vaccineName = vaccineName;
		this.vaccinecompany = vaccinecompany;
		this.cost = cost;
	}
	
	

}
