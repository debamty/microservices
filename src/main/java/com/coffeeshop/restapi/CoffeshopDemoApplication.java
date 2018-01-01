package com.coffeeshop.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.coffeeshop.restapi")
public class CoffeshopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeshopDemoApplication.class, args);
	}
}
