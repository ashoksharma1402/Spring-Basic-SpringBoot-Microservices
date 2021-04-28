package com.ashokit.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PanCard {
	@Id
	@GeneratedValue
	private Long id;
	private String panNo;
	
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date panIssueDate;
	
	
	//private Long person_FK;

}
