package com.cts.scd.service;

public class GreetServiceCustomizableImpl implements GreetService {

	private String greeting;

	@Override
	public String greet(String userName) {
		return String.format("%s! %s!", greeting, userName);
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
}
