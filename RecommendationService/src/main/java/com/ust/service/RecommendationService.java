package com.ust.service;

import java.util.List;

import com.ust.model.Recommendation;

public interface RecommendationService {
	
	List<Recommendation> findByUserId(String userId);

	List<Recommendation> findAllRecommendation();
	
	Recommendation addRecommendation(Recommendation recommendation);
	
	boolean deleteRecommendation(Recommendation recommendation);
	
	Recommendation findById(String id,String userId);

}
