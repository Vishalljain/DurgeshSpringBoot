package com.in28minutes.microservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class RateController {
	
	@GetMapping("/hello")
	@RateLimiter(name="default")
	public String helloall() {
		return "hello";
	}
	@GetMapping("/hello1")
	//@Bulkhead(name="default")
	@Bulkhead(name="sample-a")
	public String helloall1() {
		return "helloall";
	}

}
