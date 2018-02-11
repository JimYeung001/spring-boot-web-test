package com.jim.webtest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jim.webtest.controller.HomeController;
import com.jim.webtest.model.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebTestApplicationTests {
	
	@Autowired
	private HomeController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	protected ObjectMapper mapper;
	
	
	@Before
	public void setUp() {
		mapper = new ObjectMapper();
		
		
	}
	

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/greeting/greet1").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andDo(print())
//			.andReturn().getResponse().getContentAsString();
			.andExpect(status().isOk()).andDo(print())
//			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$.name", is("greet1")));
//			.andExpect(content().string(containsString("Hello World!")));
	}
	
	@Test
	public void saveGreetingAndReturnedSavedObject() throws Exception {
		Greeting greeting = new Greeting("greet2", "This is greeting message 2");
		
		String jsonContent = mapper.writeValueAsString(greeting);
		
		this.mockMvc.perform(post("/greeting").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonContent)).andDo(print())
//			.andReturn().getResponse().getContentAsString();
			.andExpect(status().isOk())
//			.andExpect(jsonPath("$", hasSize(1)))
			.andExpect(jsonPath("$.name", is("greet2")));
	}
	
	
//	@Test
	public void shouldReturePersonJsonObjectFromService() throws Exception {
		
		
		this.mockMvc.perform(get("/people/{id}", "Yeung")
		.accept(MediaType.APPLICATION_JSON)
		.contentType(MediaType.APPLICATION_JSON)).andDo(print())
//		.andReturn().getResponse().getContentAsString();
		.andExpect(status().isOk());
//		.andExpect(content().string(containsString("Hello World!")));
	}

}
