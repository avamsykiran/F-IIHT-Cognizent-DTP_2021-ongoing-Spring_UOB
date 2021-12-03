package com.cts.scd.service;

public class GreetServiceSimpleImpl implements GreetService{

	@Override
	public String greet(String userName) {
		return String.format("Hello! %s!",userName);
	}

}
