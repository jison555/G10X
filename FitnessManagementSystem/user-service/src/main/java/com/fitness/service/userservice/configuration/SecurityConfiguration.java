package com.fitness.service.userservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

	// SecurityFilterChain provides security to applicaiton. so we provide filter
	// conditions here.
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated() // tells to autheticate all request
		);

		http.httpBasic(withDefaults()); // tells we don't want a web page.but we need only a popup
		http.csrf().disable();

		return http.build();
	}
}
