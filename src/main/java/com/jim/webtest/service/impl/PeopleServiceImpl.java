package com.jim.webtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jim.webtest.model.Person;
import com.jim.webtest.repository.PeopleRepository;
import com.jim.webtest.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private PeopleRepository personRepository;

	@Override
	public List<Person> findPerson(String name) {
		return getPersonRepository().findByLastName(name);
	}

	public PeopleRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PeopleRepository personRepository) {
		this.personRepository = personRepository;
	}

	
}
