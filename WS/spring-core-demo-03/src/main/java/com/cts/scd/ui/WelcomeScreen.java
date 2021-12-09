package com.cts.scd.ui;

import java.util.Scanner;

import com.cts.scd.service.GreetService;
import com.cts.scd.service.GreetServiceSimpleImpl;
import com.cts.scd.service.GreetServiceTimeBasedImpl;

public class WelcomeScreen {

	private GreetService greetService1;
	private GreetService greetService2;
	private GreetService greetService3;

	public WelcomeScreen() {
	}

	public GreetService getGreetService1() {
		return greetService1;
	}

	public void setGreetService1(GreetService greetService1) {
		this.greetService1 = greetService1;
	}

	public GreetService getGreetService2() {
		return greetService2;
	}

	public void setGreetService2(GreetService greetService2) {
		this.greetService2 = greetService2;
	}

	public GreetService getGreetService3() {
		return greetService3;
	}

	public void setGreetService3(GreetService greetService3) {
		this.greetService3 = greetService3;
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
