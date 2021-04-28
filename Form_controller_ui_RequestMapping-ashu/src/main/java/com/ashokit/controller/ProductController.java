package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping("/prodreg")
	public String showProductRegistrationPage() {
		
		return "ProductRegestration";
		
	}

}
