package com.infybuzz.cloud.feign;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value="address-service")
public class AddressLoadBalancingConfig {
	
	@LoadBalanced
	@Bean
	public Feign.Builder feBuilder(){
		return Feign.builder();
	}

}
