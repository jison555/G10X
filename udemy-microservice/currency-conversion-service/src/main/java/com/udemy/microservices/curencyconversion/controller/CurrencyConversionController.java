package com.udemy.microservices.curencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservices.curencyconversion.bean.CurrencyConversion;
import com.udemy.microservices.curencyconversion.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversion retriveExchangeValue = currencyExchangeProxy.retriveExchangeValue(from, to);
		return new CurrencyConversion(retriveExchangeValue.getId(), from, to, quantity,
				retriveExchangeValue.getConversionMultiple(),
				quantity.multiply(retriveExchangeValue.getConversionMultiple()), retriveExchangeValue.getEnvironment());
	}

}
