package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.StatisticsYearReport;

public interface CustomStatisticsDAO {
	
	public List<StatisticsYearReport> getYearReport(String username);
	
}