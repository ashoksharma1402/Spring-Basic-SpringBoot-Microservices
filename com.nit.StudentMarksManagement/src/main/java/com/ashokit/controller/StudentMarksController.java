package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.StudentMarks;
import com.ashokit.service.IStudentMarksService;

@RestController
public class StudentMarksController {
	
	@Autowired
	private IStudentMarksService studentMarksService;
	
	@PostMapping("/save")
	public StudentMarks save(@RequestBody StudentMarks studentMarks) {
		
		StudentMarks saveStudentMarks = studentMarksService.save(studentMarks);
		return saveStudentMarks;
		
	}
	
	@GetMapping("/get")
	public List<StudentMarks> findAll() {
		List<StudentMarks> findAll = studentMarksService.findAll();
		return findAll;
		
	}

	@GetMapping("/getpage")
	public List<StudentMarks> findAllAccoringToPage(@RequestParam Integer pageNo,@RequestParam   Integer pageSize) {
		pageNo=pageNo-1;
		List<StudentMarks> findAll = studentMarksService.findAllAccordingtoPage(pageNo,pageSize);
		return findAll;
		
	}
	
	@GetMapping("/findbyid/{id}")
	public StudentMarks findById(@PathVariable Integer id) {
		StudentMarks findById = studentMarksService.findById(id);
		return findById;
		
	}
	@GetMapping("/deletebyid/{id}")
	public String deleteById(@PathVariable Integer id) {
		studentMarksService.deleteById(id);
		return "student details is deleted whose id is "+id;
		
	}
	
	@GetMapping("/pagebypage")
	public List<StudentMarks> pageByPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize){
		
		return null;
		
		
	}

}































/*
 * @GetMapping("/2nd") public String secondHighestSalary() { 
 * Integer secondHighestSalary = employeeEervice.secondHighestSalary();
 * return "second height salary in table:::"+secondHighestSalary;
 * }
 * 
 * @GetMapping("/deleteEmpbyid/{id}") 
 * public String deleteEmployeeById(@PathVariable Integer id) {
 * employeeEervice.deleteEmployeebyId(id); 
 * return "employee having id::"+id+" is deleted"; }
 */
