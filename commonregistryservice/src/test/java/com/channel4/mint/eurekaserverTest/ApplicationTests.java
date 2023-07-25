package com.channel4.mint.eurekaserverTest;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.channel4.mint.eurekaserver.EurekaRegistration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EurekaRegistration.class)
@WebAppConfiguration

@IntegrationTest("server.port=1119")
public class ApplicationTests {
	
@Value("${local.server.port}")
private int port;


	@Test
	public void adminLoads() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + port + "/env", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Test
	public void eurekaRegistration_test() throws Exception{
		String [] arg={""};
		EurekaRegistration.main(arg);
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + port + "/eureka/apps", Map.class);
		System.out.println(entity);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		
	}

}
