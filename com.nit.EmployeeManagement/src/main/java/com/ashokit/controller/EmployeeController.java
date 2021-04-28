package com.ashokit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Employee;
import com.ashokit.error.ErrorResponse;
import com.ashokit.service.IEmployeeService;

@RestController//(@controller+@ResponseBody)
//@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {

		Employee employee2 = employeeService.save(employee);

		System.out.println("hello");

		return employee2;
	}

	@GetMapping("/get")
	//@ResponseBody
	public List<Employee> getEmployee() {
		List<Employee> employee = employeeService.getEmployee();

		//return "employee present is employee table"+employee;
		return employee;

	}

	/*
	 * @PostMapping("/wel") public String welcomePage() {
	 * 
	 * return "welcome";
	 * 
	 * 
	 * }
	 */

	@GetMapping("/empbyid/{id}")	
	public Employee getEmployeeById(@PathVariable Integer id) {
		Employee employee = employeeService.getEmpById(id);
		return employee;

	}


	@GetMapping("/2nd")
	public String secondHighestSalary() {
		Integer secondHighestSalary = employeeService.secondHighestSalary();

		return "second height salary in table:::"+secondHighestSalary;

	}

	@GetMapping("/deleteEmpbyid/{id}")	
	public String deleteEmployeeById(@PathVariable Integer id) {
		employeeService.deleteEmployeebyId(id);
		return "employee having id::"+id+" is deleted";
	}


	@DeleteMapping("/deleteById/{id}")
	public String deletebyid(@PathVariable Integer id) {
		employeeService.deleteById(id);
		return "employee having "+id+" get deleted";

	}


	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		String msg= employeeService.updateAndsave(employee);
		return msg;

	}



	//WORKING WITH RESPONSEENTITY CLASS

	@PostMapping("/save2")
	public ResponseEntity<?> save2(@RequestBody Employee employee) {

		Employee employee2 = employeeService.save(employee);



		//return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(employee2,HttpStatus.ACCEPTED);
	}



	@GetMapping("/empbyid2/{id}")	
	public ResponseEntity<?> getEmployeeById2(@PathVariable Integer id) {

		/*
		 * if(id==2|| id==5 || id==7) { Employee employee =
		 * employeeService.getEmpById(id); }
		 */


		return new ResponseEntity<ErrorResponse>(new ErrorResponse("plese enter valid id 2 or 5 or 7",700,"NOT_VALID_ID", new Date()),HttpStatus.BAD_REQUEST);




	}}
