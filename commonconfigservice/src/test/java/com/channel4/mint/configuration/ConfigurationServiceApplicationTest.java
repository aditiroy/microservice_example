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
* File Name:  ConfigurationServiceApplicationTest.java
* File created Date : 18-May-2018 11:44:55
* 
* @author HCL
* 
*****************************************************************/
package com.channel4.mint.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * The class ConfigurationServiceApplicationTest is used to test ConfigurationServiceApplication.
 *
 * @author HCL
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConfigurationServiceApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")


public class ConfigurationServiceApplicationTest {

/** The port. */
@Value("${local.server.port}")
	private int port = 0;
	

	/**
	 * Configuration available.
	 */
	@Test
	public void configurationAvailable() {
	
		Environment environment = new RestTemplate().getForObject("http://localhost:" + port + "/app/cloud", Environment.class);
		assertFalse(environment.getPropertySources().isEmpty());
		assertEquals("jdbc:oracle:thin:@C-MNT-DEVORA01:1521:MNTDEV1", environment.getPropertySources().get(0).getSource().get("spring.datasource.url").toString());
		
	}
	
	/**
	 * Env get available.
	 */

    @Test
	public void envGetAvailable() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new RestTemplate().getForEntity("http://localhost:" + port + "/admin/env", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
}
