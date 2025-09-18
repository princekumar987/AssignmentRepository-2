package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CumstomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CumstomerServiceApplication.class, args);
        System.out.println("CustomerService Started");
	}

}
