package com.tamuvii.service.impl;

import com.tamuvii.dao.LocalizedMovieDataDao;
import com.tamuvii.model.LocalizedMovieData;
import com.tamuvii.service.LocalizedMovieDataManager;

public class LocalizedMovieDataManagerImpl extends GenericManagerImpl<LocalizedMovieData, String> implements LocalizedMovieDataManager{
	
	LocalizedMovieDataDao localizedMovieDataDao;
	
	public LocalizedMovieDataManagerImpl(LocalizedMovieDataDao localizedMovieDataDao) {
		super(localizedMovieDataDao);
		this.localizedMovieDataDao = localizedMovieDataDao;
	}
	
	
}
