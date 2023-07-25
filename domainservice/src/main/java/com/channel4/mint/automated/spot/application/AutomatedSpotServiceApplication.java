/*
 * 
 */
package com.channel4.mint.automated.spot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// TODO: Auto-generated Javadoc
/**
 * Main Class for Boot application.
 *
 * @author gsaini
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.channel4")
public class AutomatedSpotServiceApplication extends WebMvcConfigurerAdapter {

	/**
	 * main method for boot application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AutomatedSpotServiceApplication.class, args);
	}

}
