package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Tourist;
import com.ashokit.exception.TouristNotFoundException;
import com.ashokit.repository.ITouristRepository;

@Service("touristService")
public class TouristManagementServiceImpl implements ITouristManagementService {
	
	@Autowired
	private ITouristRepository touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		Integer  idVal = touristRepo.save(tourist).getTId();
		return "Tourist is Registered having the id value :: " +idVal;
//		Tourist save = touristRepo.save(tourist);
//		return "Tourist is Registered having the id value :: " + save.getTId();
		
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list= touristRepo.findAll();
		list.sort((t1,t2)->t1.getTId().compareTo(t2.getTId()));
		return list;
	}

	@Override
	public Tourist fetchTouristByID(Integer tId) throws TouristNotFoundException {
		return touristRepo.findById(tId)
				.orElseThrow(()-> new TouristNotFoundException(tId+" tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional= touristRepo.findById(tourist.getTId());
		if(optional.isPresent()) {
			touristRepo.save(tourist);// save(-), performs either save obj or update obj operation
		return tourist.getTId()+" tourist is updated";
		}
		else {
			throw new TouristNotFoundException(tourist.getTId()+" tourist not found"); 
		}
		
	}

	@Override
	public String deleteTourist(Integer tID) throws TouristNotFoundException {
		Optional<Tourist> findById = touristRepo.findById(tID);
		if(findById.isPresent()) {
			touristRepo.delete(findById.get());
			return tID+" Tourist deleted.";
		}
		else {
			throw new TouristNotFoundException(tID+" Tourist not found");
		}		
	}//deleteTourist Method

	@Override
	public String updatetouristBudgetById(Integer tId, Float hikePercent) throws TouristNotFoundException {
		 Optional<Tourist> findById = touristRepo.findById(tId);
		 if(findById.isPresent()) {
			 Tourist tourist = findById.get();
			 tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercent/100)));
			 touristRepo.save(tourist);
			 return "tourist Budget is updated";
		 }
		 else {
			 throw new TouristNotFoundException(tId+" Tourist not found");
		 }
		
	}

}
