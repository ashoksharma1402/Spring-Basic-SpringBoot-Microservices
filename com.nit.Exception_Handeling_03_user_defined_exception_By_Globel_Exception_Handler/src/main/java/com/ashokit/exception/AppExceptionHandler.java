package com.ashokit.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(value=NullPointerException.class)
	public String handleNullPointerException(Model model) {
		model.addAttribute("errMsg", "Some problem occured. Please try after sme time");
		return "error";

	}
	
	@ExceptionHandler(value=NoBookFoundException.class)
	public String handleNoBookFoundException() {
		
		return "customError";
		
	}

}
