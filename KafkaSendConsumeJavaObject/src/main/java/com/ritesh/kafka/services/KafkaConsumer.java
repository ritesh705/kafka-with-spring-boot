package com.ritesh.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ritesh.kafka.model.Customer;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="${kafka.topic}")
    public void processMessage(Customer customer)
	{
		System.out.println("received content = " + customer);
    }
}
