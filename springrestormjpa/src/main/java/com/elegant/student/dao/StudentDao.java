package com.elegant.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elegant.student.model.StudentModel;

@Repository
public interface StudentDao extends JpaRepository<StudentModel, Integer> {

}
