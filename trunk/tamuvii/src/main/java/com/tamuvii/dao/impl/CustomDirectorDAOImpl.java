package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomDirectorDAO;
import com.tamuvii.pojo.DirectorDetail;
import com.tamuvii.pojo.SocialMovie;

public class CustomDirectorDAOImpl extends SqlMapClientDaoSupport implements CustomDirectorDAO {
	
	public CustomDirectorDAOImpl() {
		super();
	}

	public DirectorDetail getDirectorDetail(Integer director) {
		return (DirectorDetail) getSqlMapClientTemplate().queryForObject("custom_director.getDirectorDetail", director);
	}

	@SuppressWarnings("unchecked")
	public List<SocialMovie> getDirectorDetailSocialMovieList(Integer director) {
		return getSqlMapClientTemplate().queryForList("custom_director.getDirectorDetailSocialMovieList", director);
	}

}