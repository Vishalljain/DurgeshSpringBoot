package com.bharath.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bharath.springcloud.dto.Coupon;
import com.bharath.springcloud.model.Product;
import com.bharath.springcloud.repo.ProductRepo;

@RestController
@RequestMapping("productapi")
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponSevice.url}")
	private String couponServiceURL;
	
	@RequestMapping(value="/products",method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepo.save(product);
		
	}
	 

}
