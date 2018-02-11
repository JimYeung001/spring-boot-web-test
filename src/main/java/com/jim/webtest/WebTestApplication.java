package com.jim.webtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jim.webtest.model.Greeting;
import com.jim.webtest.repository.GreetingRepository;

@SpringBootApplication
public class WebTestApplication implements CommandLineRunner {
	
	@Autowired
	private GreetingRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WebTestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();
		
		Greeting greeting = new Greeting("greet1", "This is greeting message");
		
		repository.save(greeting);
		
		
		
	}
}
