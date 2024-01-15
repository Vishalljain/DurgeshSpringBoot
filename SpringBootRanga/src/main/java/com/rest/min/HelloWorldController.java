package com.rest.min;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		HelloWorldBean hwb = new HelloWorldBean();
		hwb.setMessage("Hello World");
		return hwb;
}
	@GetMapping(path="/hello-world-internalized")
	public String helloWorldInternalization(@RequestHeader(name="Accept-Language",required=false)Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
		
		//return "Hello World";
		
	}

}
//why required=false indiactes there is a request header call accept lng then accept it else it is not really mandatory