package com.crystalcrumbs.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystalcrumbs.model.Student;

@RestController
public class StudentController {
	
	@GetMapping("/stu-info")
	public ResponseEntity<Student> getStudentInfo(Student student){
		Student stu = new Student(1,"Adekunle","Malta",20);
		return new ResponseEntity<Student>(stu,HttpStatus.OK);		
	}

	@PostMapping("/add-stu")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		System.out.println(student);
		String res = "Student added successfully";
		
		return new ResponseEntity<String>(res,HttpStatus.CREATED);
	}
}
