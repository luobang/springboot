package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BanlanceTokenConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanlanceTokenConsumerApplication.class, args);
	}

}

