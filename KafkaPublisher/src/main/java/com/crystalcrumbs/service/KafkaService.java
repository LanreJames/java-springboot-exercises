package com.crystalcrumbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Customer;
import com.crystalcrumbs.util.AppConstant;


@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public String addCustomerMessage(Customer customer) {

		kafkaTemplate.send(AppConstant.TOPIC_NAME, customer);
		return "Customer data added in kafka server";
	}

}
