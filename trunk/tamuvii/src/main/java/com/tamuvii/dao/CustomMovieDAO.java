package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;

public interface CustomMovieDAO {
	
	public List<ShelfItem> getMoviesByUsername(String username);
	
	public SocialMovie getSocialMovieDetails(Integer movieId);
	
	public PersonalMovie getPersonalMovieDetails(PersonalMovieFilterMap personalMovieFilterMap);
	
}
