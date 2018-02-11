package com.jim.webtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jim.webtest.model.Person;

@Service
public interface PeopleService {

	public List<Person>  findPerson(String id);
	
}
