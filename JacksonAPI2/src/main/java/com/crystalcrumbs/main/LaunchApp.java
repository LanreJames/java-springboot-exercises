package com.crystalcrumbs.main;

import java.io.*;
import java.util.ArrayList;

import com.crystalcrumbs.model.Alien;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LaunchApp {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException  {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		//String json = mapper.writeValueAsString(alien1);
	 Alien alien = mapper.readValue(new File("json/sample.json"), Alien.class);
		
		
		System.out.println(alien);
				

	}

}
