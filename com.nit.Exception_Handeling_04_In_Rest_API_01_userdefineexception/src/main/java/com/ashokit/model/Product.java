package com.ashokit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
	
	private String pId;
	private String pName;
	private Double price;

}
