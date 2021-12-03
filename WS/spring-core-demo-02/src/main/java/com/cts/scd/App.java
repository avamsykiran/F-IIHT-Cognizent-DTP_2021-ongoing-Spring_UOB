package com.cts.scd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.scd.ui.WelcomeScreen;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		WelcomeScreen screen= (WelcomeScreen) context.getBean("ws");
		screen.show();
	}

}
