package com.crystalcrumbs.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.crystalcrumbs.model.Customer;
import com.crystalcrumbs.util.AppConstant;

public class ConsumerKafkaConfig {
	
	@Bean
	public ConsumerFactory<String, Customer> consumerFactory (){
		
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConstant.HOST);
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(configProps);
		
	}
	
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Customer> kafkaListenerFactory()
	{
	ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
	
	factory.setConsumerFactory(consumerFactory());
	
	return factory;
			
	}

}
