package com.cts.scd;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.cts.scd")
@PropertySource("classpath:application.properties")
public class AppConfig {
	
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
