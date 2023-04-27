package com.udemy.microservice.apiGateway.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

	// if we want to customize the routes
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		return builder.routes() // if we dont want to customize any routes
				.route(p -> p.path("/currency-exchange/**")
						// .filters(f -> f.rewritePath("/currency-exchange-service",
						// "/currency-exchange/"))
						.uri("lb://CURRENCY-EXCHANGE-SERVICE"))
/*
* If we find a path '/currency-exchange/**', it will check the naming-server
* for 'CURRENCY-EXCHANGE-SERVICE' service registered with eureka and do the
* load balancing.
*/
// The '/**' path will append after the naming server	
				
				.route(p -> p.path("/currency-conversion/**")
						// .filters(f -> f.rewritePath("/currency-exchange-service",
						// "/currency-exchange/"))
						.uri("lb://CURRENCY-CONVERSION-SERVICE"))
				.build();

//		return builder.routes().route(p -> p.path("/get") // if the path is get we need to redirect it to below url
//				.filters(f -> f.addRequestHeader("MyHeader", "MyURL") // custom add header
//						.addRequestParameter("params", "MyValue")) // custom adding params
//				.uri("http://httpbin.org.80"))
//				.route(p -> p.path("/currency-exchage/**")
//						// if the request comming with path '/currency-exchange' we direct it using the naming
//						// server and load-balance
//						// and we also do load-balacing
//						.uri("lb://CURRENCY-EXCANGE-SERVICE"))
//				.build();

	}

}
