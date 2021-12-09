package com.cts.scd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.scd.service.Counter;
import com.cts.scd.ui.WelcomeScreen;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		WelcomeScreen screen= (WelcomeScreen) context.getBean("ws");
		screen.show();
		
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
	}

}
