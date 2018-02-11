package com.jim.webtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jim.webtest.model.Person;
import com.jim.webtest.service.PeopleService;

@RestController
//@RequestMapping("/api")
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleController {

	@Autowired
	private PeopleService peopleService;

	@RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
	public Person findPerson(@PathVariable String id) {
		List<Person> people = getPeopleService().findPerson(id);
		if(people.size() > 0) {
			return people.get(0);
		}else {
			return new Person();
		}
	}

	public PeopleService getPeopleService() {
		return peopleService;
	}

	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}


}
