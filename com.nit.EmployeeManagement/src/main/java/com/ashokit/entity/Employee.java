package com.ashokit.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_salary")
	private Integer empSalery;
	
	@Column(name="emp_address")
	private String empAddress;
	
	@Column(name="is_active")
	private boolean status;
	
	
	//@Column(name="Date_Of_Registration")
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date doj;
	
	

}
