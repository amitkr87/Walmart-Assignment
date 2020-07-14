package com.walmart.service;

import java.util.List;
import java.util.Optional;

import com.walmart.entity.Employee;

public interface EmployeeService {

	public void addEmployee(Employee emp);
	public Optional<Employee> getEmployeeById(int id);
	public List<Employee> getAllEmployee();
	public void updateEmployee(int id,Employee emp);
	public void deleteEmployeeById(int id);
	public void deleteAllEmployee();
}
