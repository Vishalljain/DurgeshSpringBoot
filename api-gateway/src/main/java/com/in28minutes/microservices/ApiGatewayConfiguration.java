package com.in28minutes.microservices;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
@Bean
public RouteLocator gatewayRLocator(RouteLocatorBuilder builder) {
	return builder.routes()
			.route(p->p.path("/currency-exchange/**")
					.uri("lb://currency-exchange"))
			.route(p->p.path("/currency-conversion/**")
					.uri("lb://currency-conversion"))
			.route(p->p.path("/currency-conversion-feign/**")
					.uri("lb://currency-conversion"))
			.route(p->p.path("/currency-conversion-new/**")
					.filters(f->f.rewritePath(
							"/currency-conversion-new/(?<segment>.*)",
							"/currency-conversion-feign/${segment}"))
					.uri("lb://currency-conversion"))
			
			.build();
			
	//rewritePath(old,replace)
	//the next thing is define the regular expression identifying the next thing as a segment
	//so we would use (?<segment>.* and in the next line we want to append so use ${segment}
}
}
