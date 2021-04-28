package com.ashokit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Student;
import com.ashokit.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/save")
	public String saveStudent() {
		Student student = new Student(1,"ashu",87,5);
		Student saveStudent = studentService.saveStudent(student);
		return "Students save with following details: - "+saveStudent;
		
	}
	
	@GetMapping("/get")
	public String getStudent() {
		List<Student> student = studentService.getStudent();
		return "list of all students: -"+student;
	}
	
	@GetMapping("/saveall")
	public String saveStudentList() {
		
		List<Student> studentList=Arrays.asList(new Student(1,"ashu",87,5),new Student(2,"ashok",55,12),
												new Student(3,"preeti",98,12),new Student(4,"shanvi",100,1),
												new Student(5,"radha",75,12));
		List<Student> saveStudentList = studentService.saveStudentList(studentList);
		return "studentlist saved with following details: -"+saveStudentList;
		
	}
	@GetMapping("/sbyid")
	public String getStudentByID() {
		Student studentByID = studentService.getStudentByID(1);
		
		return "student details of id 1 is: -"+studentByID;
	}

}