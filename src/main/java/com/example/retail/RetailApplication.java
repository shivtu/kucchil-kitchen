package com.example.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = ProductsRepository.class)
public class RetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}

}
