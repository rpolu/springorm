package com.elegant.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elegant.spring.entity.Employees;
import com.elegant.spring.exceptions.EmpException;
import com.elegant.spring.services.EmpServices;

@Controller
public class EmployeeController {

	@Autowired
	private EmpServices services;

	@RequestMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView view = new ModelAndView("home");
		return view;
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
	public ModelAndView registerEmp(HttpServletRequest req) {
		String strEmpId = req.getParameter("empId");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		Employees emp = new Employees();
		emp.setEmpId(Integer.parseInt(strEmpId));
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		try {
			services.joinEmployee(emp);
		} catch (EmpException e) {
			e.printStackTrace();
		}
		ModelAndView view = new ModelAndView("home");
		return view;
	}
}
