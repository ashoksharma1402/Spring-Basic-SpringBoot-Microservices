package com.ashokit.service;

import org.springframework.stereotype.Service;

import com.ashokit.exception.NoProductFoundException;
import com.ashokit.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Override
	public Product findProductById(Integer pId) {
		if(pId==101) {
			return new Product("101","Keyboard",800.00);
			
		}
		else {
			throw new NoProductFoundException("No Product Found");
		}
		
		
	}

}
