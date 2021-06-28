package com.ust.service;

import java.util.List;

import com.ust.model.Favourite;
public interface FavouriteService 
{
	
	List<Favourite> findByUserId(String userId);
	
	List<Favourite> findAllFavourite();
	
	Favourite addFavourite(Favourite favourite);
	
	boolean deleteFavourite(Favourite favourite);
	
	Favourite findById(String id,String userId);

}
