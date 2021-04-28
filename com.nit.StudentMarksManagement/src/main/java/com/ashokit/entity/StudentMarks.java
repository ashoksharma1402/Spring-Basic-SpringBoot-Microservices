package com.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="S_Marks")
public class StudentMarks {
	@Id
	@GeneratedValue
	@Column(name="S_Id")
	private Integer studentId;
	
	@Column(name="S_Name")	
	private String studentName;
	
	@Column(name="S_Marks")
	private Integer studentMarks;
	
	@Column(name="S_Class")
	private Integer studentClass;

}
