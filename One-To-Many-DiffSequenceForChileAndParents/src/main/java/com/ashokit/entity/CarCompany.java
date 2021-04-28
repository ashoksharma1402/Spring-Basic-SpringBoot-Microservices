package com.ashokit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class CarCompany implements Serializable{
	@Id
	@GeneratedValue //takes default sequence hibernate_sequesnce
	private Integer compId;
	
	private String companyName;
	private String location;
	
	@OneToMany(targetEntity = CarModel.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval =true)
	@JoinColumn(name = "company_id",referencedColumnName = "compId")
	private List<CarModel> models;
	

}
