package com.springrest.springrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringrestdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestdemoApplication.class, args);
	}

}
