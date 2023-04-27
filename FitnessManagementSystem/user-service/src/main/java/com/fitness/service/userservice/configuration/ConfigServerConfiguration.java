package com.fitness.service.userservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("user-fitness-service")
public class ConfigServerConfiguration {
	
	private int minimum;

}
