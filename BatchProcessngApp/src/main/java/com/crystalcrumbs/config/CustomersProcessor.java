package com.crystalcrumbs.config;

import org.springframework.batch.item.ItemProcessor;

import com.crystalcrumbs.model.Customers;

public class CustomersProcessor implements ItemProcessor<Customers, Customers> {

		@Override
	public Customers process(Customers item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
