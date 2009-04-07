package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.ShelfItem;

public interface MovieManager {
	
	public List<ShelfItem> getMoviesByUsername(String username);

}
