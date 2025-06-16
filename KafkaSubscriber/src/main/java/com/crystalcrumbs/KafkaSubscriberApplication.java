package com.crystalcrumbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.crystalcrumbs.util.AppConstant;

@SpringBootApplication
public class KafkaSubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSubscriberApplication.class, args);
	}
	
	
	@KafkaListener(topics= AppConstant.TOPIC_NAME, groupId="group_crystalcrumbs_customer")
	public void SubscribeMsgKafkaTopic(String custData) {
		System.out.println("Message is coming from kafka server");
		System.out.println(custData);
	}

}
