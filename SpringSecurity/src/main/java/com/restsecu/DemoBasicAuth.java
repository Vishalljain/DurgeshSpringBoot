package com.restsecu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoBasicAuth {
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
		
	}
	@GetMapping("/bye")
	public String sayBye() {
		return "Bye!GetLost";
		
	}

}
