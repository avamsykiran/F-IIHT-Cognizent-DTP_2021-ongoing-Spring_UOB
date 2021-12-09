package com.cts.scd.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.scd.service.GreetService;

@Component("ws")
public class WelcomeScreen {

	@Autowired
	@Qualifier("greetServiceCustomizableImpl")
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService2;
	
	@Autowired
	@Qualifier("greetServiceTimeBasedImpl")
	private GreetService greetService3;

	public WelcomeScreen() {
	}

	public void show() {
		Scanner scan = new Scanner(System.in);
		System.out.print("User name? ");
		String userName = scan.next();
		System.out.println(greetService1.greet(userName));
		System.out.println(greetService2.greet(userName));
		System.out.println(greetService3.greet(userName));
	}
}
