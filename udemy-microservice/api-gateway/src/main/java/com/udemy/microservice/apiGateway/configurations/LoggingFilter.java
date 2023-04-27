package com.udemy.microservice.apiGateway.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


//This component is used to log details of the service coming through api-gatway
@Component
public class LoggingFilter implements GlobalFilter{
	
	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//here we are logging path of the request
		logger.info("path of the request received -> {}",exchange.getRequest().getPath());
		logger.info("URI of the request received -> {}",exchange.getRequest().getURI());
//chain will continue to call the services
		return chain.filter(exchange);
	}
	
	

}
