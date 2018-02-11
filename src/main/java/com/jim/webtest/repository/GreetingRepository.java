package com.jim.webtest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jim.webtest.model.Greeting;

public interface GreetingRepository extends MongoRepository<Greeting, String> {
	
	public Greeting findByName(String name);

}
