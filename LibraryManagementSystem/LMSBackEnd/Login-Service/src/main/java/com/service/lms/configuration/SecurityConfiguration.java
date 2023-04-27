package com.service.lms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private MyUserDetailService userDetailsService1;

	
	//provide authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//set our configuration to auth object
//		auth.inMemoryAuthentication()
//		.withUser("admin").password("admin").roles("ADMIN")
//		.and()
//		.withUser("user").password("user").roles("USER");
		
		//JPA Authentication
		auth.userDetailsService(userDetailsService1);
	}
	
	//provide authorization
	//USE BASED ON RESTRICTED LEVEL
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().
//		.antMatchers("/api/auth/signin").hasRole("ADMIN")
//		.antMatchers("/api/auth/user").hasRole("ADMIN").
////		.antMatchers("/api/auth/**").permitAll().
		and().formLogin();
		//.antMatchers("/user").hasAnyRole("ADMIN","USER")
		//.antMatchers("/").permitAll()

	}
	
	@Bean
	public PasswordEncoder getPWEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
