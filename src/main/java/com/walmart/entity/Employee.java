package com.walmart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	@NotNull(message="ID must be positive number")
	//@Positive(message="ID must be positive number")
	private int empID;

	@Column(nullable = false)
	@NotEmpty(message="First Name cannot be null")
	@Size(min=2,message="First Name should have atleast 2 characters")
	private String firstName;
	
	@Column(nullable = false)
	@NotEmpty(message="Last Name cannot be null")
	@Size(min=2,message="Last Name should have atleast 2 characters")
	private String lastName;
	
	@Column(nullable = false)
	//@NotBlank(message="Age cannot be blank")
	//@Positive(message="Age must be positive number")
	@NotNull(message="Age cannot be blank")
	private int age;
	
	@Column(nullable = false)
	//@Positive(message="Salary must be positive number")
	@NotNull(message="Salary must be positive number")
	private float salary;
		
}
