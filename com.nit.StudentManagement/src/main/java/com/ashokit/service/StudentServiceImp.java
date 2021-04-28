package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Student;
import com.ashokit.repository.StudentRepository;

@Service
public class StudentServiceImp implements IStudentService {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		Student student2 = repo.save(student);
		return student2;
	}
	
	@Override
	public List<Student> getStudent() {
		List<Student> listOfAll = repo.findAll();
		return listOfAll;
	}
	
	@Override
	public List<Student> saveStudentList(List<Student> studentList) {
		// TODO Auto-generated method stub
		List<Student> saveAll = repo.saveAll(studentList);
		return saveAll;
	}

	@Override
	public Student getStudentByID(Integer sid) {
		Optional<Student> findById = repo.findById(sid);
		Student student = findById.get();
		return student;
	}

}