package com.in28minutes.microservices;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {//"http:localhost:8100/currency-conversion/from/USD/to/INR/quantity/10"
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion CalculateCurrencyConversion(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity) {
		HashMap<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		System.out.println(from);
		uriVariables.put("to", to); 
		System.out.println(to);
		//RestTemplate can be used to make rest api calls.getForEntity->we would send a get request and we want to get a object back That is the reason why we are using getforEntity() method which is present in resttemplate
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);//the return response shld be converted into the structure what we have in CurrencyConversion.class//i would want to pass in the values of from and to and the way you can actually do that is by creating something called urivariables
		CurrencyConversion currencyConversion = responseEntity.getBody();
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());
		
	}

}
//you have observed is that the currencyConversion structure matches the response of the currency exchange microservice therefore these value automatically get mapped that currencyexchange id get mapped to currencyconversion id,currencyexchange from mapped to currencyconversion  from,to - to to,conversionMultiple to conversionMultiple and environment to environment