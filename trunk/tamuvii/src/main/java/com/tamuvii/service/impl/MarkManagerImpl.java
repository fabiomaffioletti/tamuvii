package com.tamuvii.service.impl;

import com.tamuvii.dao.MarkDao;
import com.tamuvii.model.Mark;
import com.tamuvii.service.MarkManager;

public class MarkManagerImpl extends GenericManagerImpl<Mark, String> implements MarkManager {
	MarkDao markDao;
	
	public MarkManagerImpl(MarkDao markDao) {
		super(markDao);
		this.markDao = markDao;
	}

}