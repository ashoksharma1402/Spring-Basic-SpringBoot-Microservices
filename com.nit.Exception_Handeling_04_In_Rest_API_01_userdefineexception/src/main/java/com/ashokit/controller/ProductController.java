package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.model.Product;
import com.ashokit.service.IProductService;


@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/getProduct")
	public Product getProductDataById(@RequestParam("pId") String pId) {
		return productService.findProductById(Integer.parseInt(pId));

	}
	

}
