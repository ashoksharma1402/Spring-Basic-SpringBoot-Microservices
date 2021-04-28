package com.ashokit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class CarModel implements Serializable{
	
	@Id
	@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gen1",sequenceName = "car_model_seq",initialValue = 101,allocationSize = 1)
	
	private Long modelid;
    private String modelName;
    private String type;
    private String feulType;
}
