package com.virtuous.bookmytripservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookmytripServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmytripServiceDiscoveryApplication.class, args);
	}

}
