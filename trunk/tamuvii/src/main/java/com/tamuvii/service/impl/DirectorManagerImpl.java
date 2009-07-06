package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomDirectorDAO;
import com.tamuvii.dao.DirectorDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Director;
import com.tamuvii.pojo.DirectorDetail;
import com.tamuvii.service.DirectorManager;

public class DirectorManagerImpl implements DirectorManager {
	private MovieDAO movieDao = null;
	private DirectorDAO directorDao = null;
	private CustomDirectorDAO customDirectorDao = null;
	
	public void setCustomDirectorDao(CustomDirectorDAO customDirectorDao) {
		this.customDirectorDao = customDirectorDao;
	}
	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}
	public void setDirectorDao(DirectorDAO directorDao) {
		this.directorDao = directorDao;
	}


	
	public List<Director> getAllDirectors() {
		// TODO Auto-generated method stub
		return null;
	}

	public DirectorDetail getDirectorDetailById(Integer director) {
		DirectorDetail directorDetail = customDirectorDao.getDirectorDetail(director);
		directorDetail.setMovies(customDirectorDao.getDirectorDetailSocialMovieList(director));
		return directorDetail;
	}

}