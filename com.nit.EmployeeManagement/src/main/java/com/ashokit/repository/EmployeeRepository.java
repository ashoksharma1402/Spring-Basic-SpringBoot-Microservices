package com.ashokit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query(value="select max(empSalary) from Employee where empSalary<(select max(empSalary) from Employee)",nativeQuery = true)
	public Integer secondHegiestSalary();

	
	@Modifying
	@Transactional
	@Query("update Employee e set e.status=false where e.empId=:id")
	public void softDelete(Integer id);

}
