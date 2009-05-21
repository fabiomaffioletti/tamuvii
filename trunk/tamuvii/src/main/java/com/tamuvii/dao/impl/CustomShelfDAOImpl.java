package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomShelfDAO;
import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.ShelfItem;

public class CustomShelfDAOImpl extends SqlMapClientDaoSupport implements CustomShelfDAO {
	
	public CustomShelfDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<ShelfItem> getShelfByUsername(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getShelfByUsername", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<ShelfItem> getWishedMoviesByUsername(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getWishedMoviesByUsername", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getPersonalMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getPersonalMoviesIds", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getShelfMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getShelfMoviesIds", username);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getWishedMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getWishedMoviesIds", username);
	}

	@SuppressWarnings("unchecked")
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getPersonalMoviesIdsAndWishedFlags", username);
	}

}