package com.ashokit.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.dto.PersonDto;
import com.ashokit.entity.Person;
import com.ashokit.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@PostMapping("/savePerson")
	public ResponseEntity<?> savePerson(@RequestBody PersonDto personDto){
		
		modelMapper.getConfiguration().setAmbiguityIgnored(true);		
		Person person = modelMapper.map(personDto, Person.class);
		
		Person person2 = personRepo.save(person);
		
		return ResponseEntity.ok(person2);
		
		
		
	}

}
