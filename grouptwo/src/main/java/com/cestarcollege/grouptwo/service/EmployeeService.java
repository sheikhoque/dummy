package com.cestarcollege.grouptwo.service;

import java.util.List;

import com.cestarcollege.grouptwo.model.Employee;

public interface EmployeeService {
	Employee getEmployeeById(long id);
	List<Employee> getAllEmployees();
	Employee save(Employee e);
}
