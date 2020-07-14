package com.walmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.entity.Employee;
import com.walmart.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return empRepo.findById(id);
	}
	
	@Override
	public void updateEmployee(int id, Employee emp) {
		if(getEmployeeById(id).isPresent()) {
			empRepo.save(emp);
		}
	}
	
	@Override
	public void deleteEmployeeById(int id) {
		empRepo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public void deleteAllEmployee() {
		empRepo.deleteAll();
	}
	
	
}
