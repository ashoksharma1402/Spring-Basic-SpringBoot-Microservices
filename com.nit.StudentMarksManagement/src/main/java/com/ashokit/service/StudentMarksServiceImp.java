package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.entity.StudentMarks;
import com.ashokit.repository.StudentMarksRepository;

@Service
public class StudentMarksServiceImp implements IStudentMarksService {

	@Autowired
	private StudentMarksRepository repo;
	

	@Override
	public StudentMarks save(StudentMarks studentMarks) {
		StudentMarks saveStudentMarks = repo.save(studentMarks);
		return saveStudentMarks;
	}

	@Override
	public List<StudentMarks> findAll() {
		List<StudentMarks> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public List<StudentMarks> findAllAccordingtoPage( Integer pageNo,Integer pageSize) {
		Pageable paging=PageRequest.of(pageNo,pageSize);
		Page<StudentMarks> pageResult = repo.findAll(paging);
		if(pageResult.hasContent()) {
			List<StudentMarks> list = pageResult.getContent();
			return list;
		}
		else {
			//return null;
			return new ArrayList<>();
		}

	}
	
	@Override
	public List<StudentMarks> pageByPage(Integer pageNo, Integer pageSize) {
		  Pageable paging = PageRequest.of(pageNo,pageSize);
		  Page<StudentMarks> pageResult = repo.findAll(paging);
		  if(pageResult.hasContent()) {
			  List<StudentMarks> list = pageResult.getContent();
			  return list;
		  }
		  else {
			  //return null
			  return new ArrayList<>();
		  }
		
	}
	

	@Override
	public StudentMarks findById(Integer id) {
		Optional<StudentMarks> findById = repo.findById(id);
		StudentMarks studentMarks = findById.get();
		return studentMarks;
	}

	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
		
	}

	

}
