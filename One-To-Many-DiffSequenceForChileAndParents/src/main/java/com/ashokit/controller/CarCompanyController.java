package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.CarCompany;
import com.ashokit.repository.CarCompanyRepository;

@RestController
public class CarCompanyController {
	@Autowired
	private CarCompanyRepository carCompanyRepository;
	
	@PostMapping("/saveCompanyandCarDetails")
public ResponseEntity<?> saveCompanyandCarDetails(@RequestBody CarCompany carCompany){
	CarCompany carCompany2 = carCompanyRepository.save(carCompany);
	
	return ResponseEntity.ok(carCompany2);
	
}

}
