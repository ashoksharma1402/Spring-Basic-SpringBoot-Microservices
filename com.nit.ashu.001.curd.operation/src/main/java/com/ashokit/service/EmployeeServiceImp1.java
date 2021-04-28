package com.ashokit.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.ashokit.entity.or.model.Employee1;
import com.ashokit.repository.EmployeeRepository1;

@Service
public class EmployeeServiceImp1 implements IEmployeeService1 {

	@Autowired
	private EmployeeRepository1 repo; 

	@Override
	public Employee1 save(Employee1 employee1) {
		employee1.setStatus(Boolean.TRUE);
		employee1.setCreatedDate(LocalDateTime.now());

		Employee1 emp = repo.save(employee1);

		return emp;
	}
	
	@Override
	public List<Employee1> getAllEmployee() {
		List<Employee1> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public List<Employee1> getAllEmployeePageByPage(Integer pageNo, Integer pageSize) {
		Pageable pagging = PageRequest.of(pageNo, pageSize);
		Page<Employee1> pageResult = repo.findAll(pagging);

		if(pageResult.hasContent()) {
			List<Employee1> contentList = pageResult.getContent();
			return contentList;
		}
		else {
			return new ArrayList<>();
		}

	}

	@Override
	public Employee1 findById(Integer id) {
		Optional<Employee1> findById = repo.findById(id);
		Employee1 employee1 = findById.get();
		return employee1;
	}

	@Override
	public void deleteById(Integer id) {
		repo.softDeleteById(id);
	}

	@Override
	public void update(Employee1 employee1) {
		Integer id=employee1.getEmpId();
		Optional<Employee1> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			Employee1 employee2 = optional.get();
		}
		
		
	}

	

}
