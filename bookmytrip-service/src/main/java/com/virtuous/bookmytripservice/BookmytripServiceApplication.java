package com.virtuous.bookmytripservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookmytripServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmytripServiceApplication.class, args);
	}

}
