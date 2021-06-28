package com.ust.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.model.Recommendation;
import com.ust.repository.RecommendationRepository;

@Service
public class RecommendationServiceImpl implements RecommendationService{
	
	@Autowired
	private RecommendationRepository recommendationRepository;
	

	public RecommendationServiceImpl(RecommendationRepository recommendationRepository) {
		this.recommendationRepository = recommendationRepository;
	}

	@Override
	public List<Recommendation> findByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Recommendation> list = recommendationRepository.findByUserId(userId);
		return list;
	}

	@Override
	public List<Recommendation> findAllRecommendation() {
		// TODO Auto-generated method stub
		List<Recommendation> list = recommendationRepository.findAll();
		return list;
	}

	@Override
	public Recommendation addRecommendation(Recommendation recommendation) {
		// TODO Auto-generated method stub
		System.out.println(recommendation);
		List<Recommendation> list = findByUserId(recommendation.getUserId());
		Iterator itr = list.iterator();
		String dataId = recommendation.getDataId();
		boolean flag = false;
		while(itr.hasNext()) {
			Recommendation r = (Recommendation) itr.next();
			if(dataId.equals(r.getDataId())) {
				flag = true;
			}
		}
		if(flag == false) {
			Recommendation recom = recommendationRepository.save(recommendation);
			return recom;
		}
		return null;
	}

	@Override
	public boolean deleteRecommendation(Recommendation recommendation) {
		// TODO Auto-generated method stub
		Recommendation rec = recommendationRepository.findByDataIdAndUserId(recommendation.getDataId(), recommendation.getUserId());
		if(rec == null) {
			return false;
		}
		recommendationRepository.delete(recommendation);
		return true;
	}

	@Override
	public Recommendation findById(String id, String userId) {
		// TODO Auto-generated method stub
		Recommendation rec = recommendationRepository.findByDataIdAndUserId(id, userId);
		return rec;
	}

}
