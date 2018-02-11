package com.jim.webtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jim.webtest.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HttpRequestIntegrationTest {
	
	private static final String url = "http://localhost:";
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void greetingShouldBeReturnedWithDefaultMessage() {
		assertThat(this.template.getForObject(url + port + "/api", String.class))
			.contains("Hello World!");
	}
	
	
	@Test
	public void greetingShouldBeReturnedFromService() {
		assertThat(this.template.getForObject(url + port + "/api/greeting", String.class))
			.contains("Hello World!");
	}
	
	@Test
	public void getPersonByLastName() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

//		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		
		ResponseEntity<Person> person = this.template.exchange(url + port + "/api/people/yeung", HttpMethod.GET, new HttpEntity<Void>(headers), Person.class);
		assertThat(this.template.getForObject(url + port + "/api/people/yeung", Person.class))
		.asString()
		.contains("Hello World!");
	}

}
