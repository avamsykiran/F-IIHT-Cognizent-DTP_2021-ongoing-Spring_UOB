package com.cts.scd.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceCustomizableImpl implements GreetService {

	private String greeting;

	@Override
	public String greet(String userName) {
		return String.format("%s! %s!", greeting, userName);
	}
}
