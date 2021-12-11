package com.ashokit.processor;

import org.springframework.batch.item.ItemProcessor;

import com.ashokit.model.Employee;

public class EmployeeInfoItemProcessor implements ItemProcessor<Employee,Employee> {

	@Override
	public Employee process(Employee emp) throws Exception {
		if(emp.getSalary()>=100000) {
			emp.setGrossSalary(Math.round(emp.getSalary()+emp.getSalary()*0.4f));
			emp.setNetSalary(Math.round(emp.getGrossSalary()-emp.getGrossSalary()*0.2f));
			return emp;
		}
		else {
			return null; // other employee will be filter here
		}
		/*else {
			emp.setGrossSalary(emp.getSalary());
			emp.setNetSalary(emp.getSalary());
			return emp;*/
		}
		
	}
