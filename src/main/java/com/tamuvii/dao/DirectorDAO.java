package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.Director;

public interface DirectorDAO {
	
	public List<Director> getAll(Map queryMap);
	public Director getDirectorById(Long id);
	
	public Long addDirector(Director director);
	public void updateDirector(Director director);
	public void deleteDirectorById(Long id);

}
