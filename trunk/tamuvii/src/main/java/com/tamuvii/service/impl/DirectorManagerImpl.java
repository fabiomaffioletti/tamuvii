package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.DirectorDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Director;
import com.tamuvii.model.MovieExample;
import com.tamuvii.model.MovieExample.Criteria;
import com.tamuvii.pojo.DirectorDetail;
import com.tamuvii.service.DirectorManager;

public class DirectorManagerImpl implements DirectorManager {
	private MovieDAO movieDao = null;
	private DirectorDAO directorDao = null;
	
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

	@SuppressWarnings("unchecked")
	public DirectorDetail getDirectorDetailById(Integer director) {
		DirectorDetail directorDetail = new DirectorDetail();
		directorDetail.setDirector(directorDao.selectByPrimaryKey(director));
		
		MovieExample movieExample = new MovieExample();
		Criteria movieCriteria = movieExample.createCriteria();
		movieCriteria.andDirectorEqualTo(director);
		directorDetail.setMovies(movieDao.selectByExample(movieExample));
		
		return directorDetail;
	}

}