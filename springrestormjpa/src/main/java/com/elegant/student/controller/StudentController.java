package com.elegant.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elegant.student.model.StudentModel;
import com.elegant.student.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<Void> saveStudent(@RequestBody StudentModel studentModel) {
		studentService.saveStudent(studentModel);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
