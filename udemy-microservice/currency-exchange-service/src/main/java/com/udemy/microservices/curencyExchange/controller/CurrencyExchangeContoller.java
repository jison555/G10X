package com.udemy.microservices.curencyExchange.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservices.curencyExchange.bean.CurrencyExchange;
import com.udemy.microservices.curencyExchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeContoller {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeContoller.class); 
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	//spring provides this class to get details of the specific enviroment
	@Autowired
	private Environment environment;

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	private CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
//INFO [currency-exchange-service,7106641235279b060ebe7ff204151dba,08071659344dec4e][0;39m [35m25492[0;39m [2m---[0;39m [2m[nio-8000-exec-5][0;39m [36mc.u.m.c.c.CurrencyExchangeContoller     [0;39m [2m:[0;39m retrive Exchange value called with USD to INR

		logger.info("retrive Exchange value called with {} to {}",from,to);
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if(currencyExchange==null) {
			throw new RuntimeException("unable to find this exchange");
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);   // to find port number of the instance running
		return currencyExchange;
	}

}
