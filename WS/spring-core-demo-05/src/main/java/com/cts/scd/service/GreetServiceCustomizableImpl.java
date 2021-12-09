package com.cts.scd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceCustomizableImpl implements GreetService {

	@Value("${greet.greeting}")
	private String greeting;

	@Override
	public String greet(String userName) {
		return String.format("%s! %s!", greeting, userName);
	}
}
