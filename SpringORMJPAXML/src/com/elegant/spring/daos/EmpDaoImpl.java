package com.elegant.spring.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.elegant.spring.entity.Employees;
import com.elegant.spring.exceptions.EmpException;

@Repository
public class EmpDaoImpl implements EmpDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Employees> getEmpList() throws EmpException {
		Query qry = manager.createNamedQuery("allEmps");
		return qry.getResultList();
	}

	@Override
	public Employees getEmpDetails(int empNo) throws EmpException {
		Employees emp = manager.find(Employees.class, empNo);
		return emp;
	}

	@Override
	public Employees insertNewEmployee(Employees emp) throws EmpException {
		manager.persist(emp);
		return emp;
	}
}
