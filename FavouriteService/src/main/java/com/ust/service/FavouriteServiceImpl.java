package com.ust.service;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.model.Favourite;
import com.ust.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {
	

	@Autowired
	private FavouriteRepository favouriteRepository;
	
	FavouriteServiceImpl(FavouriteRepository favouriteRepository){
		this.favouriteRepository  = favouriteRepository;
	}
	
	@Override
	public List<Favourite> findByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Favourite> list = favouriteRepository.findByUserId(userId);
		return list;
	}
	

	@Override
	public List<Favourite> findAllFavourite() {
		// TODO Auto-generated method stub
		List<Favourite> list = favouriteRepository.findAll();
		return list;
	}


	@Override
	public Favourite addFavourite(Favourite favourite) {
		// TODO Auto-generated method stub
		List<Favourite> list = findByUserId(favourite.getUserId());
		Iterator itr = list.iterator();
		String song = favourite.getSong();
		boolean flag = false;
		while(itr.hasNext()) {
			Favourite r = (Favourite) itr.next();
			if(song.equals(r.getSong())) {
				flag = true;
			}
		}
		if(flag == false) {
			Favourite fav = favouriteRepository.save(favourite);
			return fav;
		}
		return null;
	}

	@Override
	public boolean deleteFavourite(Favourite favourite) {
		// TODO Auto-generated method stub
		
		Favourite fav = favouriteRepository.findBySongIdAndUserId(favourite.getSongId(), favourite.getUserId());
		if(fav == null) {
			return false;
		}
		favouriteRepository.delete(favourite);
		return true;
			
	}


	@Override
	public Favourite findById(String id,String userId) {
		// TODO Auto-generated method stub
		Favourite fav = favouriteRepository.findBySongIdAndUserId(id, userId);
		return fav;
	}
}