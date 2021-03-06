package com.kasundissanayake.quote.quoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class QuoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteServiceApplication.class, args);
	}

}
