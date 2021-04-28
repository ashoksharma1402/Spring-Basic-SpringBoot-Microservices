package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.or.model.Employee1;
import com.ashokit.service.IEmployeeService1;

@RestController
public class EmployeeController1 {
	
	@Autowired
	private IEmployeeService1 employeeService1;
	
	@PostMapping("/save")
	public Employee1 save(@RequestBody Employee1 employee1) {
		Employee1 employee2 = employeeService1.save(employee1);
		System.out.println("hello");
		return employee2;		
	}
	
	@GetMapping("/getAll")
	public List<Employee1> getAllEmployee(){
		List<Employee1> allEmployee = employeeService1.getAllEmployee();
		return allEmployee;
		
	}
	
	@GetMapping("/getAllPageByPage")
	public List<Employee1> getAllEmployeePageByPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
		pageNo=pageNo-1;
		List<Employee1> allEmployee = employeeService1.getAllEmployeePageByPage(pageNo,pageSize);
		
		return allEmployee;
	}
	
	@GetMapping("/findById/{id}")
	public Employee1 findByEmployee1(@PathVariable Integer id) {
		Employee1 findById = employeeService1.findById(id);
		return findById;
	}
	
	//Soft delete
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable Integer id) {
		employeeService1.deleteById(id);		
		return "Employee details is deleted whoes id is = "+id;
	}

}
