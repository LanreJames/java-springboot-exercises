package com.crystalcrumbs.rest;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;

import com.crystalcrumbs.model.Student;
import com.crystalcrumbs.service.IGreetingsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTests {
	
	@MockitoBean
	private IGreetingsService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	//ResultActions result;
	
	
	@Test
	//@Disabled
	void testGetWish() throws Exception {
		
		//Create the mocking behavior
		Mockito.when(service.generategreetings()).thenReturn("Good Morning");
		
		//requestObject
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet1");
		//try {
		ResultActions	result = mockMvc.perform(requestBuilder);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
		
		MvcResult mvcResult = result.andReturn();
		
		MockHttpServletResponse response = mvcResult.getResponse();
		
		int statusCode = response.getStatus();
		
		assertEquals(200,statusCode);
		
	}
	
	@Test
	void testAddStudentInfo() throws Exception
	{
		//Student stud = new Student();
		Mockito.when(service.addStudent(ArgumentMatchers.any())).thenReturn(true);
		Student stud = new Student(1,"Lanre","James",22);
		
		 ObjectMapper mapper = new ObjectMapper();
		 String json = mapper.writeValueAsString(stud);
		 
		 
		 MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add-stu")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(json);
		 
			//try {
			ResultActions	result = mockMvc.perform(requestBuilder);
			//} catch (Exception e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
			
			
			
			MvcResult mvcResult = result.andReturn();
			
			MockHttpServletResponse response = mvcResult.getResponse();
			
			int statusCode = response.getStatus();
			
			assertEquals(201,statusCode);
		
	}

}
