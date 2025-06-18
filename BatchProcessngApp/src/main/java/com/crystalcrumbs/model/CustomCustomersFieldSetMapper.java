package com.crystalcrumbs.model;

import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class CustomCustomersFieldSetMapper implements FieldSetMapper<Customers> {
	
	private BeanWrapperFieldSetMapper<Customers> wrapper;
		
		public CustomCustomersFieldSetMapper() {
			wrapper = new BeanWrapperFieldSetMapper<>();
			wrapper.setTargetType(Customers.class);
			wrapper.setStrict(true); 
			
		}
		
	@Override
	public Customers mapFieldSet(FieldSet fieldSet) throws BindException {
		//Customers customers = wrapper.mapFieldSet(fieldSet);
		Customers customer = new Customers();
        customer.setStudentID(fieldSet.readString("StudentID"));
        customer.setFirstName(fieldSet.readString("FirstName"));
        customer.setLastName(fieldSet.readString("LastName"));
        customer.setGender(fieldSet.readString("Gender"));
        customer.setDateOfBirth(fieldSet.readString("DateOfBirth"));
        customer.setEmail(fieldSet.readString("Email"));
        customer.setPhone(fieldSet.readString("Phone"));
        customer.setLevel(fieldSet.readString("Class")); // CSV uses 'Class', entity uses 'Level'
        customer.setDepartment(fieldSet.readString("Department"));
        customer.setEnrollmentYear(fieldSet.readString("EnrollmentYear"));
        return customer;
		
		
		//customers.setLevel(fieldSet.readString("Class"));
		//return customers;
	}

}