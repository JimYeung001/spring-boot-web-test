package com.jim.webtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jim.webtest.model.Greeting;
import com.jim.webtest.repository.GreetingRepository;
import com.jim.webtest.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	@Autowired
	private GreetingRepository greetingReopistory;

	@Override
	public Greeting findByName(String name) {
		Greeting greeting = this.greetingReopistory.findByName(name);
		return greeting;
	}

	@Override
	public Greeting saveGreeting(Greeting greeting) {
		Greeting saved = this.greetingReopistory.insert(greeting);
		return saved;
	}

}
