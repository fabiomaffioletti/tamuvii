package com.tamuvii.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomDirectorDAO;
import com.tamuvii.pojo.DirectorDetail;

public class CustomDirectorDAOImpl extends SqlMapClientDaoSupport implements CustomDirectorDAO {
	
	public CustomDirectorDAOImpl() {
		super();
	}

	public DirectorDetail getDirectorDetail(Integer director) {
		return (DirectorDetail) getSqlMapClientTemplate().queryForObject("custom_director.getDirectorDetail", director);
	}

}