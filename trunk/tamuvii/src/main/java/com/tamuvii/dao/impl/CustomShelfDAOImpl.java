package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomShelfDAO;
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

}