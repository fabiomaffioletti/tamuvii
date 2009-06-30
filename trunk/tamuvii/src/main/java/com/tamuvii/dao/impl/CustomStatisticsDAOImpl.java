package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomStatisticsDAO;
import com.tamuvii.pojo.StatisticsYearReport;

public class CustomStatisticsDAOImpl extends SqlMapClientDaoSupport implements CustomStatisticsDAO {
	
	public CustomStatisticsDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<StatisticsYearReport> getYearReport(String username) {
		return getSqlMapClientTemplate().queryForList("custom_statistics.getYearReport", username);
	}

}