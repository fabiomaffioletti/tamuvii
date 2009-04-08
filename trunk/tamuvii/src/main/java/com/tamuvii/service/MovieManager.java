package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;

public interface MovieManager {
	
	public List<ShelfItem> getMoviesByUsername(String username);
	
	public SocialMovie getSocialMovieDetails(Integer movieId);

}
