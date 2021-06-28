package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Recommendation;
import com.ust.service.RecommendationService;

@RestController
public class RecommendationController {
	@Autowired
	private RecommendationService recService;

	public RecommendationController(RecommendationService recService) {
		this.recService = recService;
	}
	
	@GetMapping("/")
	public String welcome() {
		return "welcome..!";
	}
	
	@GetMapping(value="/musix/recommendation/get/{userId}")
	public ResponseEntity<?> getRecommandationByUserId(@PathVariable("userId") String userId){
		List<Recommendation> list = recService.findByUserId(userId);
		if(list.size()==0) {
			return new ResponseEntity<String>("No Recommendation",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<List<Recommendation>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/musix/recommendation/add")
	public ResponseEntity<?> addRecommand(@RequestBody Recommendation recom){
		Recommendation rec = recService.addRecommendation(recom);
		if(rec==null) {
			return new ResponseEntity<String>("Recommendation already added",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Recommendation added",HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(value="/musix/recommendation/delete/{dataId}/{userId}")
	public ResponseEntity<?> deleteRecommandation(@PathVariable("dataId") String dataId, @PathVariable("userId") String userId){
		Recommendation rec = recService.findById(dataId, userId);
		if(rec==null) {
			return new ResponseEntity<String>("No such Recommendation found",HttpStatus.BAD_REQUEST);
		}
		else {
			boolean isDeleted = recService.deleteRecommendation(rec);
			if(isDeleted) {
				return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("No such Recommendation found",HttpStatus.BAD_REQUEST);
			}
			
		}
	}
	
	@GetMapping(value="/musix/recommendation/allrecommendation")
	public ResponseEntity<?> getAllRecommendationByUserId( String userId){
		List<Recommendation> list = recService.findAllRecommendation();
		if(list.size()==0) {
			return new ResponseEntity<String>("No Recommendation",HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<List<Recommendation>>(list,HttpStatus.OK);
		
	}
	
	
	
}

	
	


