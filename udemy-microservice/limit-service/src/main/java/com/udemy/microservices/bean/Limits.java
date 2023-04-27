package com.udemy.microservices.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Limits {

	private int minimum;
	private int maximum;

	public Limits(int minimum, int maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}
