package com.virtuous.bookmytripgw;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
@EnableDiscoveryClient
public class BookmytripGwApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmytripGwApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/user-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://BOOKMYTRIP-USER-SERVICE"))
				.route(r -> r.path("/bookmytrip-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://BOOKMYTRIP-SERVICE"))
				.build();
	}

}
