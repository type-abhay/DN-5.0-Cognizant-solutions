package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {
	
	//Entry point of the SpringBoot Application
	public static void main(String[] args) {
		
		System.out.println("Inside main method");

//		This method starts the Spring Boot application and 
//		initializes all required configurations and dependencies.
		SpringApplication.run(SpringLearnApplication.class, args);
		
		System.out.println("Application started");
		
	}

}
