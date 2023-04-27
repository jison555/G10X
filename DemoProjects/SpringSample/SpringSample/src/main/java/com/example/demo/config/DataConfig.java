package com.example.demo.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataConfig {
	
	@Bean
	@Profile({"dev"})
	public void configDev() throws IOException {
	System.out.println("dev profile on");
	}
	
	@Bean
	@Profile({"stage"})
	public void configStage() throws IOException {
	System.out.println("stage profile on");
	}
	
	@Bean
	@Profile({"prod"})
	public void configProd() throws IOException {
	System.out.println("prod profile on");
	}
	
	
	
}
