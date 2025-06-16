package com.crystalcrumbs.main;

import java.util.ArrayList;

import com.crystalcrumbs.model.Alien;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LaunchApp {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		Alien alien1 = new Alien(1,"Adebayo","Iju");
		Alien alien2 = new Alien(2,"Adebayo","Iju");
		Alien alien3 = new Alien(3,"Adebayo","Iju");
		
		ArrayList<Alien> aliens=new ArrayList<>();
		
		aliens.add(alien3);
		aliens.add(alien2);
		aliens.add(alien1);

		System.out.println(alien1);
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		//String json = mapper.writeValueAsString(alien1);
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(aliens);
		
		
		System.out.println(json);
				

	}

}
