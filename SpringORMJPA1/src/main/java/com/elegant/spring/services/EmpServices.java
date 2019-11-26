package com.elegant.spring.services;

import java.util.List;

import com.elegant.spring.entity.Employees;
import com.elegant.spring.exceptions.EmpException;

public interface EmpServices {
	public List<Employees> getEmpList() throws EmpException;
	public Employees getEmpDetails(int empNo) throws EmpException;
	public Employees joinEmployee(Employees emp) throws EmpException;
}
