package com.ust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ust.model.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, String>{
	List<Recommendation> findByUserId(String userId);

	Recommendation findByDataIdAndUserId(String id,String userId);

}