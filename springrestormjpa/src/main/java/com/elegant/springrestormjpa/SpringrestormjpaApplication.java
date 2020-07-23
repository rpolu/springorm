package com.elegant.springrestormjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.elegant")
@EntityScan("com.elegant.student.model")
@EnableJpaRepositories(basePackages = "com.elegant")
public class SpringrestormjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestormjpaApplication.class, args);
	}

}
