package com.elegant.spring.daos;

import java.util.List;

import com.elegant.spring.entity.Employees;
import com.elegant.spring.exceptions.EmpException;

public interface EmpDao {
	public List<Employees> getEmpList() throws EmpException;
	public Employees getEmpDetails(int empNo) throws EmpException;
	public Employees insertNewEmployee(Employees emp) throws EmpException;
}
