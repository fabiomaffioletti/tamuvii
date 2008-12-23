package com.tamuvii.dao.impl;

import com.tamuvii.dao.LocalizedMovieDataDao;
import com.tamuvii.dao.hibernate.GenericDaoHibernate;
import com.tamuvii.model.LocalizedMovieData;

public class LocalizedMovieDataDaoImpl extends GenericDaoHibernate<LocalizedMovieData, String> implements LocalizedMovieDataDao{

	/** Constructor method. */
	public LocalizedMovieDataDaoImpl() {
		super(LocalizedMovieData.class);
	}
	
}
