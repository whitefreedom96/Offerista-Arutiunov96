package com.offerista.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class NumberConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberConsumerApplication.class, args);
	}
}
