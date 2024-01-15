package com.infybuzz.cloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infybuzz.cloud.controller.CouponController;
import com.infybuzz.cloud.model.Coupon;
import com.infybuzz.cloud.repo.CouponRepo;

@SpringBootTest
class JunitCouponServiceApplicationTests {
	@Mock
	private CouponRepo repo;
	//now we want to inject this mocked out CouponRepo into the CouponController so marked with @InjectMock
	@InjectMocks
	private CouponController controller;

	@Test
	void testCreateCoupon() {
		//controller = new CouponController();dont want to create object because mockito will automatically create instance of the controller as it is marked with injectMock
		Coupon coupon = new Coupon();
		when(repo.save(coupon)).thenReturn(coupon);
		Coupon couponCreated = controller.Create(coupon);
		verify(repo).save(coupon);
		assertNotNull(couponCreated);//the object which has been created in post method shld not be null
	}
	
	
	@Test
	public void testGetCoupon() {
		Coupon coupon = new Coupon();
		coupon.setId(123L);
		coupon.setCode("SUPERSALE");
		coupon.setDiscount(new BigDecimal(10));
		when(repo.findByCode("SUPERSALE")).thenReturn(coupon);
		Coupon couponResponse = controller.getCoupon("SUPERSALE");
		verify(repo).findByCode("SUPERSALE");
		assertNotNull(couponResponse);
		assertEquals(new BigDecimal(10), coupon .getDiscount());
		
	}
	
	@Test
	public void testCreate_WhenNullCoupon_ThrowException() {
		//assertThrows(expectedType, Executable executable);
		assertThrows(IllegalArgumentException.class,()->{
			controller.Create(null);
		});
		
	}

}
