package com.chandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWebClientApplication.class, args);
	}

}
