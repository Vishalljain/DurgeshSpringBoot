package com.in28minutes.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CurrencyConversionServiceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceTwoApplication.class, args);
	}

}
