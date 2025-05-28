package com.crystalcrumbs.service;

import com.crystalcrumbs.model.Student;

public interface IGreetingsService {
	String generategreetings();
	Boolean addStudent(Student stud);
}
