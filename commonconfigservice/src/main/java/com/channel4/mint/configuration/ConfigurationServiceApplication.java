/*****************************************************************
* Copy right (c) Channel4 , All rights reserved.
* 
* 
*  Application Name: mint-configuration-service
* 
* This application is used for managing add sales of C4.
* Which is a public media company of UK.
* 
* 
* File Name:  ConfigurationServiceApplication.java
* File created Date : 18-May-2018 11:43:02
* 
* @author HCL
*  
*****************************************************************/
package com.channel4.mint.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * The Class ConfigurationServiceApplication is a class in mint-configuration-service.
 * 
 * @author HCL
 */
@SpringBootApplication
@EnableConfigServer
//@EnableEurekaClient
public class ConfigurationServiceApplication {

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServiceApplication.class, args);
	}
}
