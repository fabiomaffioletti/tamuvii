package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;

public class CustomMovieDAOImpl extends SqlMapClientDaoSupport implements CustomMovieDAO {
	
	public CustomMovieDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<ShelfItem> getMoviesByUsername(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getMoviesByUsername", username);
	}

	public SocialMovie getSocialMovieDetails(Integer movie) {
		return (SocialMovie) getSqlMapClientTemplate().queryForObject("custom_movie.getSocialMovieDetails", movie);
	}

	public PersonalMovie getPersonalMovieDetails(PersonalMovieFilterMap personalMovieFilterMap) {
		PersonalMovie personalMovie = (PersonalMovie) getSqlMapClientTemplate().queryForObject("custom_movie.getPersonalMovieDetails", personalMovieFilterMap);
		return personalMovie;
	}

}