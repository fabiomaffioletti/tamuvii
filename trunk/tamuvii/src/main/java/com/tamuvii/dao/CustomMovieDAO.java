package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;

public interface CustomMovieDAO {
	
	public List<ShelfItem> getMoviesByUsername(String username);
	
	public SocialMovie getSocialMovieDetails(Integer movieId);

}
