package com.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashokit.entity.StudentMarks;

@Service
public interface IStudentMarksService {
	public StudentMarks save(StudentMarks studentMarks);

	public List<StudentMarks> findAll();

	public List<StudentMarks> findAllAccordingtoPage(Integer pageNo, Integer pageSize);
	public StudentMarks findById(Integer id);
	public void deleteById(Integer id);
	public List<StudentMarks> pageByPage(Integer pageNo, Integer pageSize);
}
