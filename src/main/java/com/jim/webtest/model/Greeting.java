package com.jim.webtest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Greetings")
public class Greeting {
	
	@Id
	private String id;
	
	@Indexed
	private String name;
	
	private String message;
	
	private Date createdDate;
	
	public Greeting() {}
	
	public Greeting(String name, String msg) {
		this.name = name;
		this.message = msg;
		this.createdDate = new Date();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
