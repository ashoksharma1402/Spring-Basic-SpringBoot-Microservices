package com.ashokit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
public class ProductModel {
	
	@Id
	
	private Integer prodId;
	
	@NonNull
	private String prodCode;
	
	@NonNull
	private Integer prodCost;
	
	@NonNull
	private String prodModel;
	
	
	@NonNull
	private boolean isactive;

}
