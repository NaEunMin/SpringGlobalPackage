package com.hansung.likelion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LikelionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikelionApplication.class, args);
	}

}
