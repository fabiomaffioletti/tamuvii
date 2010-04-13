package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Director;

public interface DirectorManager {
	
	public List<Director> getAll(String filter, Integer from, Integer to);
	public Director getDirectorById(Long id);
	
	public Long addDirector(Director director);
	public Long addDirector(String name, String surname, String nickname);
	public void udpateDirector(Director director);
	public void deleteDirector(Long id);
	
}