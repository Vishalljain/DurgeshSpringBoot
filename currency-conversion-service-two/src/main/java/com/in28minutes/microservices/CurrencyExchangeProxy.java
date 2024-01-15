package com.in28minutes.microservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange",url="localhost:8000")//typically we would use the application name of the service we would want to call here
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {//we want to call currency exchange conroller that were our service is defined
	//copy the structure of currency exchange controller
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

	//you see that we have created the currency conversion bean matching the structure of the response of the currency-exchange and therefore the return values are automatically mapped into the currency conversion bean

}
