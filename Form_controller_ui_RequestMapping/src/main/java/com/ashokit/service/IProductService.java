package com.ashokit.service;

import com.ashokit.model.ProductModel;

public interface IProductService {
public ProductModel saveProductDataInDb(ProductModel product);

public void deleteById(Integer id);

}
