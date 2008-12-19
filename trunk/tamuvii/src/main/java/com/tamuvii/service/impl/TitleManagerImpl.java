package com.tamuvii.service.impl;

import com.tamuvii.dao.TitleDao;
import com.tamuvii.model.Title;
import com.tamuvii.service.TitleManager;

public class TitleManagerImpl extends GenericManagerImpl<Title, String> implements TitleManager {
	TitleDao titleDao;
	
	public TitleManagerImpl(TitleDao titleDao) {
		super(titleDao);
		this.titleDao = titleDao;
	}

}