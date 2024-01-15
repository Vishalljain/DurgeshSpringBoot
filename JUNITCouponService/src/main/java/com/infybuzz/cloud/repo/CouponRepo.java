package com.infybuzz.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infybuzz.cloud.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

	
}
