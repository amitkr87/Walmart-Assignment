package com.walmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.walmart.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
