package com.springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
@SpringBootApplication
@EnableResourceServer
public class CreateEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateEmployeeApplication.class, args);
	}

}
