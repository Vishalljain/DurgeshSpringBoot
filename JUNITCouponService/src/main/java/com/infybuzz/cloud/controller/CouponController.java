package com.infybuzz.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.cloud.model.Coupon;
import com.infybuzz.cloud.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

	@Autowired
	CouponRepo repo;
	
	
	@RequestMapping(value = "/coupons", method = RequestMethod.POST)
	public Coupon Create(@RequestBody Coupon coupon) {
		if(coupon==null) {
			throw new IllegalArgumentException("Coupon Cannot be empty");
		}
		return  repo.save(coupon);
		
	}
	@RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		return repo.findByCode(code);
	}
}
