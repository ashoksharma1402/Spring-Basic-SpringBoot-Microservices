package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/welcome")
	public String welcome(Model model) {
		model.addAttribute("msg", "welcome to ashok it");
		
		String name=null;
		name.length();
		
		return "welcome";
		
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointrtException(Model model) {
	model.addAttribute("errMsg", "Some Problem occured. Please try after some time...!!");	
		return "error";
	}

}
