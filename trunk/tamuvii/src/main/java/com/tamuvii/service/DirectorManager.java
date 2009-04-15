package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Director;
import com.tamuvii.pojo.DirectorDetail;

public interface DirectorManager {
	
	public List<Director> getAllDirectors();
	
	public DirectorDetail getDirectorDetailById(Integer director);

}
