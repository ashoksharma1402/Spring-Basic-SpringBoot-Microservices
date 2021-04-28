package com.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.model.ProductModel;
import com.ashokit.repository.ProductModelRepository;

@Service
public class ProductModelServiceImpl implements IProductService {
	//@Autowired
	private ProductModelRepository rep;

	@Override
	public ProductModel saveProductDataInDb(ProductModel product) {
		ProductModel prodmodel = rep.save(product);
		
		return prodmodel;
	}

	@Override
	public void deleteById(Integer id) {
		//rep.softDelete();
		
	}

}
