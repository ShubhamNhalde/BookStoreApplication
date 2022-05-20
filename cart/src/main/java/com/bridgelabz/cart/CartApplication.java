package com.bridgelabz.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CartApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
		log.info("Cart from book store app started");
	}
}
