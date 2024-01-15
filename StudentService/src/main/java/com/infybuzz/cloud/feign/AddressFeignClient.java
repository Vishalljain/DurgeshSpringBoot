package com.infybuzz.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infybuzz.cloud.response.AddressResponse;

//@FeignClient(url="${address.service.url}",value="address-feign-client")//here value can be anything
					//OR
//@FeignClient(url="${address.service.url11}",value="address-feign-client",path="/api/address")
//the above 2 lines are used before eureka client n eureka server into picture
//Now after eureka we need to connect address service via service name not through url

@FeignClient(value="address-service",path="/api/address")
public interface AddressFeignClient {
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id);
}


