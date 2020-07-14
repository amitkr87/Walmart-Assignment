package com.walmart.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.entity.Employee;
import com.walmart.service.EmployeeService;

@RestController
@RequestMapping("/employeeApi")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
	 
	@PostMapping("/addEmployee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee emp) {
		log.info("inside Add Employee");
		empService.addEmployee(emp);
		return ResponseEntity.ok("Employee Information is valid");
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		log.info("inside getEmployeeById method ");
		log.debug("employee Id: "+id);
		Optional<Employee> emp = empService.getEmployeeById(id);
		if (emp.isPresent())
			return new ResponseEntity<>(emp.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		log.info("inside getAllEmployee method ");
		List<Employee> empList = empService.getAllEmployee();
		if (empList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{empId}")
	public void updateEmployee(@Valid @PathVariable("empId") int empId, @RequestBody Employee emp) {
		log.info("inside updateEmployee method ");
		log.debug("employee Id: "+empId);
		empService.updateEmployee(empId, emp);
	}

	@DeleteMapping("/deleteEmployeeById/{empId}")
	public void deleteEmployeeById(@Valid @PathVariable("empId") int empId) {
		log.info("inside deleteEmployeeById method ");
		log.debug("employee Id: "+empId);
		empService.deleteEmployeeById(empId);
	}

	@DeleteMapping("/deleteAllEmployee")
	public void deleteAllEmployee() {
		log.info("inside deleteAllEmployee method ");
		empService.deleteAllEmployee();
	}
}
