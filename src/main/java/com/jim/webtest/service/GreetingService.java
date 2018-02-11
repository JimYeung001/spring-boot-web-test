package com.jim.webtest.service;

import com.jim.webtest.model.Greeting;

public interface GreetingService {
	
	public Greeting findByName(String name);
	
	public Greeting saveGreeting(Greeting greeting);

}
