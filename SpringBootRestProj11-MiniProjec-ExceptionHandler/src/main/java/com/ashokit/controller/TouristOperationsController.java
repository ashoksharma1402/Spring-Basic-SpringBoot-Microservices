package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Tourist;
import com.ashokit.service.ITouristManagementService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {
	@Autowired
	private ITouristManagementService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) throws Exception{
		
		// use service
		String resultMsg=service.registerTourist(tourist);
		return new ResponseEntity<String>(resultMsg,
				HttpStatus.CREATED);// 201 content created successfully
	
	}// method
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourist()throws Exception{
		
			List<Tourist> list = service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
	}//method

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> displayById(@PathVariable("id") Integer tId)throws Exception{
		
				Tourist fetchTouristByID = service.fetchTouristByID(tId);
			return new ResponseEntity<Tourist>(fetchTouristByID,HttpStatus.OK);
	}//method
	
	@PutMapping("/modify")	
	public ResponseEntity<String> modifiyTourist(@RequestBody Tourist tourist)throws Exception{
			String msg = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{tId}")
	public ResponseEntity<String> removeTourist(@PathVariable("tId") Integer tId)throws Exception{
		
			//use service
			String msg = service.deleteTourist(tId);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}// remove method
	
	@PatchMapping("/budgetModify/{tId}/{hike}")
	public ResponseEntity<String> modifyTouristBudgetById(@PathVariable("tId") Integer tId,
															@PathVariable("hike") Float hikePercent)throws Exception{
			//use service
			String msg = service.updatetouristBudgetById(tId, hikePercent);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
	}//budgetModify method
	}// class

