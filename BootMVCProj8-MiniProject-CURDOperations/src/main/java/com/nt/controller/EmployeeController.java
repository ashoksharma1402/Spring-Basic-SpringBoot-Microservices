package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	@Autowired
	 private IEmployeeMgmtService service;
	
	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public  String   showEmployeeReport(Map<String,Object> map) {
		//use service
		Iterable<Employee> empsList=service.getAllEmployees();
		//keep results as model attribute
		map.put("empsList", empsList);
		//return lvn;
		return "employee_report";
	}
	
	@GetMapping("/insert_employee")
	public  String   showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		   //return LNV
		return "add_employee";
	}
	
	
	@PostMapping("/insert_employee")
	public  String insertEmployee(RedirectAttributes attrs,
			@ModelAttribute("emp")Employee emp) {
		//use service
		String result=service.insertEmployee(emp);
		//add result to model attribute 
	    attrs.addFlashAttribute("resultMsg",result);
		//retunr LVN
		return "redirect:emp_report";
		
	}
	
	/*@PostMapping("/insert_employee")
	public  String insertEmployee(HttpSession ses,
			@ModelAttribute("emp")Employee emp) {
		//use service
		String result=service.insertEmployee(emp);
		//add result to model attribute 
		ses.setAttribute("resultMsg", result);
		//retunr LVN
		return "redirect:emp_report";
		
	}*/
	
	@GetMapping("/edit_employee")
	public String   showEditEmployeeFormPage(@RequestParam("eno") int no,
			                                 @ModelAttribute("emp") Employee emp) {
		//use serivce
		Employee emp1=service.getEmployeeByEno(no);
		BeanUtils.copyProperties(emp1, emp);
		//return  lvn
		return  "modify_employee";
	}
	
	@PostMapping("/edit_employee")
	public  String  editEmployee(RedirectAttributes attrs ,
			                                               @ModelAttribute("emp") Employee emp) {
		//use service
		String result=service.updateEmployee(emp);
		//keep results in model attributes
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:emp_report";
	}
	
	@GetMapping("/delete_employee")
	public   String deleteEmployee(@RequestParam("eno") int no, 
			                                                          RedirectAttributes attrs) {
		//use service
		String result=service.deleteEmployeeByEno(no);
		//keep results in model attributes
		attrs.addFlashAttribute("resultMsg", result);
		//return LVN
		return "redirect:emp_report";
	}

}
