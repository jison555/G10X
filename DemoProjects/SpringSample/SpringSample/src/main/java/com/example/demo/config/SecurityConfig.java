package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// set my security configuration to the auth object
		// set Authentication

//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		UserDetails details = User.withUsername("boo").password("boo").roles("USER").build();
//		userDetailsService.createUser(details);
//		auth.userDetailsService(userDetailsService);

		auth.inMemoryAuthentication().withUser("blah").password("blah").roles("USER").and().withUser("foo")
				.password("foo").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
//		.antMatchers("/getStudent").hasRole("USER")
//		.antMatchers("/getAllStudent").hasRole("DEVELOPER")
//		.and().formLogin();
				.antMatchers("/teacher/getAllTeachers").hasRole("USER").antMatchers("/teacher/getStudent")
				.hasRole("ADMIN")
//		.antMatchers("/**").hasAnyRole("ADMIN","USER")
				.and().formLogin();
	}

	// By default Spring-Security will provide encoding
	// for encode PW
	// here we are telling we are not providing any encoding in this method
	@Bean
	public PasswordEncoder getPWEncorder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
