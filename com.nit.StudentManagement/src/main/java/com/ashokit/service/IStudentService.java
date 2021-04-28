package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import com.ashokit.entity.Student;

public interface IStudentService {
	public Student saveStudent(Student student);
	public List<Student> getStudent();
	public List<Student> saveStudentList(List<Student> studentList);
	public Student getStudentByID(Integer sid);
}