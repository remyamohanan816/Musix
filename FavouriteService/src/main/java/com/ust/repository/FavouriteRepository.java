package com.ust.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ust.model.Favourite;


@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, String> {
	List<Favourite> findByUserId(String userId);
	
	Favourite findBySongIdAndUserId(String id,String userId);
}