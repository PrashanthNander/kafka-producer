package com.prash.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafkaProducerApplication.class, args);
		//System.out.println("Kafka Producer application started successfully.");
	}

}
