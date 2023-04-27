package com.udemy.microservices.curencyExchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.microservices.curencyExchange.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	
	CurrencyExchange findByFromAndTo(String from,String to);
}
