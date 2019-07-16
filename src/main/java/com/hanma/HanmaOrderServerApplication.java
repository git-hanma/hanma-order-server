package com.hanma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HanmaOrderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanmaOrderServerApplication.class, args);
	}

}
