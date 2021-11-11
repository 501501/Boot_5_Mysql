package com.sol.b5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Boot5MysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot5MysqlApplication.class, args);
	}

}
