package com.ashokit.dto;

import com.ashokit.entity.PanCard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
	private String pName;
	private Integer pAge;
	private String pAdd;
	private PanCard card;
	

}
