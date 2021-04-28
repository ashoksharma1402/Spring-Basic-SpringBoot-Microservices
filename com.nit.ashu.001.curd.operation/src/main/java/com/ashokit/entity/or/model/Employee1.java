package com.ashokit.entity.or.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Employee1")
public class Employee1 {
	@Id
	@GeneratedValue
	@Column(name="Emp_Id")
	private Integer empId;
	
	@Column(name="Emp_Name")
	private String empName;
	
	@Column(name="Emp_Salary")
	private Float empSal;
	
	@Column(name="Emp_Address")
	private String empAdd;
	
	@Column(name="Is_Active")
	private Boolean status;
	
	@Column(name="Date_Of_Regestration")
	private LocalDateTime createdDate;
	
	@Column(name="Date_Of_Updation")
	private LocalDateTime updatedDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dOB;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dOJ;
	
}
