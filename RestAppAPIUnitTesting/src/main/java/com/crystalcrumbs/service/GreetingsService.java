package com.crystalcrumbs.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalcrumbs.model.Student;

@Service
public class GreetingsService implements IGreetingsService {
	
	@Autowired
	private LocalTime time;
	

	@Override
	public String generategreetings() {
		// TODO Auto-generated method stub
		int hr = time.getHour();
		if (hr<12)
			return "Good Morning";
		else if(hr <16)
			return "Good Afternoon";
		else if(hr <20)
			return "Good Evening";
		else
			return "Good Night";
	}

	public Boolean addStudent(Student stud) {
		
		System.out.println(stud);
		return true;
	}
}
