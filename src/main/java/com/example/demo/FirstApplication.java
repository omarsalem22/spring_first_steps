package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
	var ctx=	SpringApplication.run(FirstApplication.class, args);
		FirstService firstService=ctx.getBean(FirstService.class);
		System.out.println(firstService.hello());
	
	}
	

}
	