package com.infybuzz.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.cloud.request.CreateAddressRequest;
import com.infybuzz.cloud.response.AddressResponse;
import com.infybuzz.cloud.service.AddressService;



@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/create")
	public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest) {//here i m sending street and city
		return addressService.createAddress(createAddressRequest);
	}
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable long id) {
		return addressService.getById(id);
	}
	
}
