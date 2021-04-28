package com.ashokit.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.or.model.Employee1;

@Repository
public interface EmployeeRepository1 extends JpaRepository<Employee1,Integer> {

	@Modifying
	@Transactional
	@Query("update Employee1 e set e.status=false where e.empId=:id")
	public void softDeleteById(Integer id);

	public void update(Employee1 employee1);
	
	/*	@Modifying
		@Query("update employee")
		public void updateById(Integer id);
		
		@Query(value="select status from Employee1 e where empId=:id)",nativeQuery = true)
		public String checkStatus();*/

}
