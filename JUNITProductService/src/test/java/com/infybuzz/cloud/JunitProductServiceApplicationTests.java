package com.infybuzz.cloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import com.infybuzz.cloud.controller.ProductController;
import com.infybuzz.cloud.dto.Coupon;
import com.infybuzz.cloud.model.Product;
import com.infybuzz.cloud.repo.ProductRepo;

@SpringBootTest
class JunitProductServiceApplicationTests {
	private static final String COUPON_CODE = "SUPERSALE";
	private static final String COUPON_SERVICE_URL = "http://localhost:9091/couponapi/coupons/";
	@InjectMocks
	private ProductController controller;
	@Mock
	private RestTemplate restTemplate;
	@Mock
	private ProductRepo repo;

	@Test
	void contextLoads() {
		Coupon coupon = new Coupon();
		coupon.setCode(COUPON_CODE);
		coupon.setDiscount(new BigDecimal(10));//2 fileds are 
		
		when(restTemplate.getForObject(COUPON_SERVICE_URL+COUPON_CODE, Coupon.class)).thenReturn(coupon);
	
		Product product = new Product();
		product.setCouponCode(COUPON_CODE);
		product.setPrice(new BigDecimal(100));//set price or null will occur as some calculation hppens
		controller.setCouponServiceUrl(COUPON_SERVICE_URL);
		when(repo.save(product)).thenReturn(product);
		Product productCreated = controller.create(product);
		verify(restTemplate).getForObject(COUPON_SERVICE_URL+COUPON_CODE, Coupon.class);
		repo.save(product);
		assertNotNull(productCreated);
		assertEquals(COUPON_CODE, productCreated.getCouponCode());
	}

}
