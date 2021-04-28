package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.CarCompany;

@Repository
public interface CarCompanyRepository extends JpaRepository<CarCompany, Integer> {

}
