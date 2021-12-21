package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Tourist;
import com.ashokit.exception.TouristNotFoundException;

public interface ITouristManagementService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristByID(Integer tId)throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist)throws TouristNotFoundException;
	public String deleteTourist(Integer tID) throws TouristNotFoundException;
	public String updatetouristBudgetById(Integer tId, Float hikePercent) throws TouristNotFoundException;
}
