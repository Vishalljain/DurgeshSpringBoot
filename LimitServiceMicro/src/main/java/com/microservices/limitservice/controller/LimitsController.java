package com.microservices.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitservice.configuration.Configuration;
import com.microservices.limitservice.controller.bean.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;
	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
//		Limits l = new Limits(1, 1000);
//		return l;
		
	}
	

}
