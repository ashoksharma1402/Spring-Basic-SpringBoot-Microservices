package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.model.ProductModel;
import com.ashokit.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	//@RequestMapping("/reg")
	//@RequestMapping(value="/reg",method = RequestMethod.GET)
	@GetMapping("/regs")
	public String showProductRegistarionPage() {
		return "ProductReg";
	}
	
	/*
	  @RequestMapping(value ="/save",method = RequestMethod.POST) public String
	  showProductData(@ModelAttribute ProductModel prod,Model model) {
	  model.addAttribute("ProductOb",prod); return "ProductData";
	  
	  }
	 */
	
	@RequestMapping(value ="/saveProd",method = RequestMethod.POST)
	public String saveProductDataInDb(@ModelAttribute ProductModel prod,Model model) {
		
		ProductModel productModel = service.saveProductDataInDb(prod);
		
		System.out.println(productModel);
		
		model.addAttribute("ProductOb",productModel);
		 return "ProductData";
		
	}
	
	
	@RequestMapping(value ="/saveP",method = RequestMethod.POST)
	@ResponseBody
	public String saveProductDataInDbAndReturnAsJson(@ModelAttribute ProductModel prod) {
		ProductModel productModel = service.saveProductDataInDb(prod);
		
		System.out.println(productModel);
		
		
		 return "hi"+productModel;
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deletebyid(@PathVariable Integer id) {
		service.deleteById(id);
		return null;
		
	}

}
