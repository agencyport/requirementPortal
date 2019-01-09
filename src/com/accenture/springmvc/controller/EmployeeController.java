package com.accenture.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.springmvc.entity.Employee;
import com.accenture.springmvc.entity.Lob;
import com.accenture.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView viewRegister(@ModelAttribute Employee employee) {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute Employee employee) {
		employeeService.createEmployee(employee);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView viewLogin(@ModelAttribute Employee employee) {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute Employee employee) {
		Employee emp = employeeService.getEmployee(employee);
		ModelAndView model = null;
		if (emp == null) {
			model = new ModelAndView("login");
			model.addObject("result", "Invalid Username or Password");
		} else {
			model = new ModelAndView("home");
			model.addObject("emp", emp.getName());
			Lob lob = new Lob();
			model.addObject("lob", lob);
		}
		return model;
	}

}