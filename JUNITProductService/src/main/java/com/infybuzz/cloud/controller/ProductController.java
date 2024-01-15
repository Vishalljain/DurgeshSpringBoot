package com.infybuzz.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infybuzz.cloud.dto.Coupon;
import com.infybuzz.cloud.model.Product;
import com.infybuzz.cloud.repo.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductController {
	@Autowired
	ProductRepo repo;
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponSevice.url}")//@Value this will not work for mockito so we create getters n setters 
	private String CouponServiceUrl;
	
	public String getCouponServiceUrl() {
		return CouponServiceUrl;
	}

	public void setCouponServiceUrl(String couponServiceUrl) {
		CouponServiceUrl = couponServiceUrl;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(getCouponServiceUrl()+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
		
	}
	
	
	/*
	 * {response
    "name":"namkeen",
    "description":"awesome",
    "price":1000,
    "couponCode":"tcs"
}
	 */
	

}
