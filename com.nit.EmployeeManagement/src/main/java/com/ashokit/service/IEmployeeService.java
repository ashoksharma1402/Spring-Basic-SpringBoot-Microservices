package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Employee;

public interface IEmployeeService {
	

	public Employee save(Employee employee);
	public List<Employee> getEmployee();
	public Employee getEmpById(Integer id);
	public Integer secondHighestSalary();
	public void deleteEmployeebyId(Integer id);
	public void deleteById(Integer id);
	public String updateAndsave(Employee employee);

}
