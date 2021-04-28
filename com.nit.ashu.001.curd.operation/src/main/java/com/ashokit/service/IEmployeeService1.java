package com.ashokit.service;



import java.util.List;

import com.ashokit.entity.or.model.Employee1;



public interface IEmployeeService1 {
	public Employee1 save(Employee1 employee1);
	public List<Employee1> getAllEmployee();
	public List<Employee1> getAllEmployeePageByPage(Integer pageNo, Integer pageSize);
	public Employee1 findById(Integer id);
	public void deleteById(Integer id);
	public void update(Employee1 employee1);
	

}
