package com.infybuzz.cloud;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/*we will use prefilter n postfilter ..using these filters we will have some cross cutting concerns in apigateway
like authenticate the request or log the request whatever u want to do u ca do using the pre n post filter

in this lecture we will create prefilter so this will get execute before the api gateways route the request to the microservice 
so here we can do authentication or log the request whatever we want to do before request goes to microservice
*/

@Configuration
public class CustomFilter implements GlobalFilter {//need to implement global filter provided by api gateway
	
	Logger logger = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		
//		//for particular student service if we want to log syntax is down
//		if(request.getURI().toString().contains("/api/student/")) {
//			
//		}
		
		logger.info("Authorization="+request.getHeaders().getFirst("Authorization"));
		//return chain.filter(exchange);//this line is responsible for routing after logging is done..after this line anything will be postfilter
		
		return chain.filter(exchange).then(Mono.fromRunnable(()->{////the  snippet is for loggin status code
			
			ServerHttpResponse response = exchange.getResponse();	
			logger.info("Post Filter="+response.getStatusCode());
		}));
	}
	//The post filter will get executed after our microservice gives reponse back to the api gateway and before our api gateway passes that response to the consumer

}
