package com.ritesh.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ritesh.kafka.model.Customer;

@Service
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@Value("${kafka.topic}")
	String kafkaTopic = "test";
	
	public void send(Customer customer)
	{
	    System.out.println("sending data=" + customer+" Topic: "+kafkaTopic);
	    kafkaTemplate.send(kafkaTopic, customer);
	}
}