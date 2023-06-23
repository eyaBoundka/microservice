package com.esprit.crew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrewServiceApplication.class, args);
	}
}
