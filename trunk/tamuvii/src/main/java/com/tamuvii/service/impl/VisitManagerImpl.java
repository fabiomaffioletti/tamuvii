package com.tamuvii.service.impl;

import java.util.Calendar;
import java.util.List;

import com.tamuvii.dao.CustomRelationshipDAO;
import com.tamuvii.dao.VisitDAO;
import com.tamuvii.model.Visit;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.VisitManager;

public class VisitManagerImpl implements VisitManager {
	private VisitDAO visitDao = null;
	private CustomRelationshipDAO customRelationshipDao = null;

	public void setVisitDao(VisitDAO visitDao) {
		this.visitDao = visitDao;
	}
	public void setCustomRelationshipDao(CustomRelationshipDAO customRelationshipDao) {
		this.customRelationshipDao = customRelationshipDao;
	}


	public void addUserVisit(String visited, String visitor) {
		Visit visit = new Visit();
		visit.setDatevisit(Calendar.getInstance().getTime());
		visit.setVisited(visited);
		visit.setVisitor(visitor);
		visitDao.insertSelective(visit);
	}


	public List<UserNeighbor> getLastUserVisitors(String username) {
		return customRelationshipDao.getLastUserVisitors(username);
	}

}