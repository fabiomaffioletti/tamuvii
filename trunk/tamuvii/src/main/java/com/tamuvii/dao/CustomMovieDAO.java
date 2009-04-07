package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.ShelfItem;

public interface CustomMovieDAO {
	
	public List<ShelfItem> getMoviesByUsername(String username);

}
