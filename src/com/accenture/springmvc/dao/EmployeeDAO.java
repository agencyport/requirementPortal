package com.accenture.springmvc.dao;

import com.accenture.springmvc.entity.Employee;

public interface EmployeeDAO {
	public void createEmployee(Employee employee);
	public Employee getEmployee(Employee employee);

}
