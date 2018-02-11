package com.jim.webtest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jim.webtest.model.Greeting;
import com.jim.webtest.service.GreetingService;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService service;

	
	@RequestMapping(value="/greeting/{name}", method = RequestMethod.GET)
	public @ResponseBody Greeting greeting(@PathVariable String name) {
		return service.findByName(name);
	}
	
	@RequestMapping(value="/greeting", method = RequestMethod.POST)
	public Greeting saveGreeting(@Valid @RequestBody Greeting greeting) {
		return this.service.saveGreeting(greeting);
		
	}

}
