package com.tamuvii.service.impl;

import com.tamuvii.dao.CustomStatisticsDAO;
import com.tamuvii.pojo.Statistics;
import com.tamuvii.service.StatisticsManager;
import com.tamuvii.service.VisitManager;

public class StatisticsManagerImpl implements StatisticsManager {
	private VisitManager visitManager = null;
	private CustomStatisticsDAO customStatisticsDao = null;


	public void setCustomStatisticsDao(CustomStatisticsDAO customStatisticsDao) {
		this.customStatisticsDao = customStatisticsDao;
	}
	public void setVisitManager(VisitManager visitManager) {
		this.visitManager = visitManager;
	}

	
	
	public Statistics getStatistics(String username) {
		Statistics statistics = new Statistics();
		statistics.setLastVisitors(visitManager.getLastUserVisitors(username));
		statistics.setYearReport(customStatisticsDao.getYearReport(username));
		return statistics;
	}

}