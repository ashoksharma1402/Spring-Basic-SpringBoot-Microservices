package com.ashokit.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Employee;
import com.ashokit.exception.WrongIdGivenException;
import com.ashokit.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee save(Employee employee) {
		employee.setStatus(Boolean.TRUE);
		employee.setCreated(LocalDateTime.now());

		Employee emp = repo.save(employee);
		return emp; 

	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> listEmp = repo.findAll();
		return listEmp;
	}

	@Override
	public Employee getEmpById(Integer id) {
		Optional<Employee> optional = repo.findById(id);
		Employee employee = optional.get();
		return employee;
	}

	@Override
	public Integer secondHighestSalary() {
		Integer secondHegiestSalary = repo.secondHegiestSalary();
		return  secondHegiestSalary;
	}

	@Override
	public void deleteEmployeebyId(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public void deleteById(Integer id) {
		repo.softDelete(id);

	}

	@Override
	public String updateAndsave(Employee employee) {
		Integer id=employee.getEmpId();
		Optional<Employee> optional = repo.findById(id);

		if(optional.isPresent()) {
			Employee employee1=optional.get();
			employee1.setEmpId(employee.getEmpId());
			//employee1.setCreated(employee.getCreated());
			employee1.setUpdated(LocalDateTime.now());
			employee1.setDob(employee.getDob());
			employee1.setDoj(employee.getDoj());
			employee1.setEmpAddress(employee.getEmpAddress());
			employee1.setEmpSalery(employee.getEmpSalery());
			employee1.setEmpName(employee.getEmpName());

			Employee employee2 = repo.save(employee1);

			if(employee!=null) {
				return "Employee data updated";
			}
			else {
				return "employee data not updated";
			}
		}

		else {
			throw new WrongIdGivenException("plsease enter valis id");
		}


	}
}
