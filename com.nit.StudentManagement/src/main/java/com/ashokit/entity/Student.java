package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="newStudent")
public class Student {
	
	@Id
	private Integer sid;
	private String sname;
	private Integer smark;
	private Integer sclass;

}
