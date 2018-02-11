package com.jim.webtest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jim.webtest.model.Person;

//@RepositoryRestResource(collectionResourceRel="people", path="people")
public interface PeopleRepository extends MongoRepository<Person, String> {	
//	List<Person> findByLastName(@Param("name") String name);
	
	List<Person> findByLastName(String name);

}
