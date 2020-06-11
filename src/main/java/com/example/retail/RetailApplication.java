package com.example.retail;

import com.example.retail.productsmodel.vegitables.VegitableInventoryRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(repositoryBaseClass = VegitableInventoryRepositoryImpl.class)
public class RetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}

}
