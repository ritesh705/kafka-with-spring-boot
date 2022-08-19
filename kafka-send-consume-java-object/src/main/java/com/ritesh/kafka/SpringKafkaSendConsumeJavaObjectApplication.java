package com.ritesh.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ritesh.kafka.model.Customer;
import com.ritesh.kafka.services.KafkaProducer;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan
@SpringBootApplication
public class SpringKafkaSendConsumeJavaObjectApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringKafkaSendConsumeJavaObjectApplication.class, args);
	}
	
	@Autowired
	KafkaProducer producer;
	
	@Override
	public void run(String... args) throws Exception
	{
		// Send Mary customer
		Customer mary = new Customer("Mary", 31);
		producer.send(mary);
		
		// Send Peter customer
		Customer peter = new Customer("Peter", 24);
		producer.send(peter);
	}
}
