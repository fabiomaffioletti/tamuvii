package com.tamuvii.pojo;

import java.util.List;

public class Statistics {
	
	private List<UserNeighbor> lastVisitors;
	private List<StatisticsYearReport> yearReport;

	public List<UserNeighbor> getLastVisitors() {
		return lastVisitors;
	}
	public void setLastVisitors(List<UserNeighbor> lastVisitors) {
		this.lastVisitors = lastVisitors;
	}
	public List<StatisticsYearReport> getYearReport() {
		return yearReport;
	}
	public void setYearReport(List<StatisticsYearReport> yearReport) {
		this.yearReport = yearReport;
	}

}