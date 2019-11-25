package com.elegant.spring.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elegant.spring.entity.Employees;
import com.elegant.spring.exceptions.EmpException;
import com.elegant.spring.services.EmpServices;

@Controller
public class EmployeeController {

	@Resource
	private EmpServices services;

	@RequestMapping("/home")
	public String getHomePage() {
		return "Home";
	}

	@RequestMapping("/empList")
	public ModelAndView getEmpList() {
		List<Employees> empList = null;
		ModelAndView mAndV = null;
		try {
			empList = services.getEmpList();
			System.out.println(empList);
			mAndV = new ModelAndView();
			// Pass-on this data to JSP
			mAndV.setViewName("EmpList");
			mAndV.addObject("list", empList);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

	@RequestMapping("/empDetails")
	public ModelAndView getEmpDetails(@RequestParam("id") int empNo) {
		ModelAndView mAndV = new ModelAndView("EmpDetails");
		Employees emp = null;
		try {
			emp = services.getEmpDetails(empNo);
			System.out.println(emp);

			// Pass-on this data to JSP
			mAndV.addObject("emp", emp);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

	@RequestMapping("/registrationPage")
	public String getRegistrationPage() {
		return "RegistrationPage";
	}

	@RequestMapping("/registration")
	public String registerEmp(HttpServletRequest req) {
		String strEmpId = req.getParameter("empId");
		Employees emp = new Employees();
		emp.setEmpId(Integer.parseInt(strEmpId));

		try {
			services.joinEmployee(emp);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		return "SuccInsert";
	}
}
