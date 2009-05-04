package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.ShelfItem;

public interface CustomShelfDAO {
	
	public List<ShelfItem> getShelfByUsername(String username);
	
	public List<ShelfItem> getWishedMoviesByUsername(String username);
	
}