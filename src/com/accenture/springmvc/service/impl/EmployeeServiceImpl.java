package com.accenture.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.springmvc.dao.EmployeeDAO;
import com.accenture.springmvc.entity.Employee;
import com.accenture.springmvc.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void createEmployee(Employee employee) {
		employeeDAO.createEmployee(employee);		
	}

	@Override
	public Employee getEmployee(Employee employee) {
		return employeeDAO.getEmployee(employee);
	}
	
	
	
	

}
