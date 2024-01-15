package com.bharath.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	@Autowired
	private CouponRepo repo;
	
	@RequestMapping(value="/coupons",method = RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon) {//here we need to mark with @RequestBody only then the incoming coupon will be deserialized into the coupon
		return repo.save(coupon);
		
	}
	@RequestMapping(value="/coupons/{code}",method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable String code) {
		return repo.findByCode(code);
		
	}

}
