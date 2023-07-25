package com.channel4.mint.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistration {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaRegistration.class, args);
	}
}