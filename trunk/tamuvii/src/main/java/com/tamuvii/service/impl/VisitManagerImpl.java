package com.tamuvii.service.impl;

import java.util.Calendar;

import com.tamuvii.dao.VisitDAO;
import com.tamuvii.model.Visit;
import com.tamuvii.service.VisitManager;

public class VisitManagerImpl implements VisitManager {
	private VisitDAO visitDao = null;

	public void setVisitDao(VisitDAO visitDao) {
		this.visitDao = visitDao;
	}


	public void addUserVisit(String visited, String visitor) {
		Visit visit = new Visit();
		visit.setDatevisit(Calendar.getInstance().getTime());
		visit.setVisited(visited);
		visit.setVisitor(visitor);
		visitDao.insertSelective(visit);
	}


}