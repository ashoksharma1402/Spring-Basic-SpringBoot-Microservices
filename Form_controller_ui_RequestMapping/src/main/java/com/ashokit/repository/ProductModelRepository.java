package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.model.ProductModel;


@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Integer> {

	//@Query
	//public void softDelete();

}
