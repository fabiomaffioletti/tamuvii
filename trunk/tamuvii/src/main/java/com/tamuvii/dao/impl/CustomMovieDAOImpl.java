package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;

public class CustomMovieDAOImpl extends SqlMapClientDaoSupport implements CustomMovieDAO {
	
	public CustomMovieDAOImpl() {
		super();
	}

	public List<ShelfItem> getMoviesByUsername(String username) {
		return getSqlMapClientTemplate().queryForList("custom.getMoviesByUsername", username);
	}

	public SocialMovie getSocialMovieDetails(Integer movieId) {
		return (SocialMovie) getSqlMapClientTemplate().queryForObject("custom.getSocialMovieDetails", movieId);
	}

}
