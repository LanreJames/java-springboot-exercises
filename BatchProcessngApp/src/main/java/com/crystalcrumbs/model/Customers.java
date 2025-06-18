package com.crystalcrumbs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customers {

	@Id
	private String studentID;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String dateOfBirth;
	
	private String email;
	
	private String phone;
	
	private String level;
	
	private String department;
	
	private String EnrollmentYear;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEnrollmentYear() {
		return EnrollmentYear;
	}

	public void setEnrollmentYear(String enrollmentYear) {
		EnrollmentYear = enrollmentYear;
	}

	public Customers(String studentID, String firstName, String lastName, String gender, String dateOfBirth,
			String email, String phone, String level, String department, String enrollmentYear) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.level = level;
		this.department = department;
		EnrollmentYear = enrollmentYear;
	}

	@Override
	public String toString() {
		return "Customers [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", phone=" + phone + ", level=" + level
				+ ", department=" + department + ", EnrollmentYear=" + EnrollmentYear + "]";
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
