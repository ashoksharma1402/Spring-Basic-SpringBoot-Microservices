package com.ashokit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Entity
public class ProductModel {
	
	@Id
	public Integer prodId;
	
	@NonNull
	public String prodCode;
	
	@NonNull
	public Integer prodCost;
	
	@NonNull
	public String prodModel;

}
