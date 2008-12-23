package com.tamuvii.dao.impl;

import org.springframework.stereotype.Repository;

import com.tamuvii.dao.MovieDao;
import com.tamuvii.dao.hibernate.GenericDaoHibernate;
import com.tamuvii.model.Movie;

/**
 * DAO for table: Movie.
 * @author autogenerated
 */
@Repository
public class MovieDaoImpl extends GenericDaoHibernate<Movie, Integer> implements MovieDao {
	
	/** Constructor method. */
		public MovieDaoImpl() {
			super(Movie.class);
		}
	}

