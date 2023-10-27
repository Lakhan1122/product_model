package com.lakhan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lakhan")
public class ProductModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductModelApplication.class, args);
	}

}
