package com.walmart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int empID;

	@Column(nullable = false)
	@NotNull
	@Size(min=2,message="First Name should have atleast 2 characters")
	private String firstName;
	
	@Column(nullable = false)
	@NotNull
	@Size(min=2,message="Last Name should have atleast 2 characters")
	private String lastName;
	
	@Column(nullable = false)
	@NotBlank(message="Age cannot be blank")
	private int age;
	
	@Column(nullable = false)
	@NotNull
	private float salary;
	/*
	 * @Column private Date dateOfBirth;
	 * 
	 * @Column private Date dateOfJoining;
	 */
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	/*
	 * public Date getDateOfBirth() { return dateOfBirth; } public void
	 * setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; } public
	 * Date getDateOfJoining() { return dateOfJoining; } public void
	 * setDateOfJoining(Date dateOfJoining) { this.dateOfJoining = dateOfJoining; }
	 */
	
}
