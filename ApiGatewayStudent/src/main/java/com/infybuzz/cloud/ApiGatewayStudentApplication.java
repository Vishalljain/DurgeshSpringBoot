package com.infybuzz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayStudentApplication.class, args);
	}

}
