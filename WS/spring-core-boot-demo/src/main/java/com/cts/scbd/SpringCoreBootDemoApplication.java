package com.cts.scbd;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.cts.scbd.service.Counter;
import com.cts.scbd.ui.WelcomeScreen;

@SpringBootApplication
public class SpringCoreBootDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreBootDemoApplication.class, args);
	}

	@Autowired
	private ApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		WelcomeScreen screen= (WelcomeScreen) context.getBean("ws");
		screen.show();
		
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());
		System.out.println(((Counter) context.getBean("counter")).getCount());		
	}

	@Bean
	public Scanner scan() {
		return new Scanner(System.in);
	}

	@Bean
	@Scope("prototype")
	public LocalDateTime currentTime() {
		return LocalDateTime.now();
	}
}
