package com.elegant.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elegant.student.dao.StudentDao;
import com.elegant.student.model.StudentModel;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	public void saveStudent(StudentModel studentModel) {
		studentDao.save(studentModel);
	}

	public StudentModel saveStudent(int rollNum) {
		Optional<StudentModel> options = studentDao.findById(rollNum);
		StudentModel studentModel = options.get();
		return studentModel;
	}

}
