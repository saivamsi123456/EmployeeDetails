package com.springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
public class CreateEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateEmployeeApplication.class, args);
	}

}
