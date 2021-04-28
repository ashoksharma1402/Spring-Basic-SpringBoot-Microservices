  package com.ashokit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;
	
	private String pName;
	private Integer pAge;
	private String pAdd;
	
	@OneToOne(targetEntity = PanCard.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "person_FK")
	private PanCard card;

}
