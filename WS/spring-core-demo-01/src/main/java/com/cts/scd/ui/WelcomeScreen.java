package com.cts.scd.ui;

import java.util.Scanner;

import com.cts.scd.service.GreetService;
import com.cts.scd.service.GreetServiceSimpleImpl;
import com.cts.scd.service.GreetServiceTimeBasedImpl;

public class WelcomeScreen {

	private GreetService greetService;
	
	public WelcomeScreen() {
	}
	
	public GreetService getGreetService() {
		return greetService;
	}

	public void setGreetService(GreetService greetService) {
		this.greetService = greetService;
	}

	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.print("User name? ");
		String userName = scan.next();
		System.out.println(greetService.greet(userName));	
	}
}
