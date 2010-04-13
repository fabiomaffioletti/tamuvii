package com.tamuvii.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.DirectorDAO;
import com.tamuvii.model.Director;

public class DirectorDAOImpl extends SqlMapClientDaoSupport implements DirectorDAO {

	@SuppressWarnings("unchecked")
	public List<Director> getAll(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("director.getAll", queryMap);
	}

	public Director getDirectorById(Long id) {
		return (Director) getSqlMapClientTemplate().queryForObject("director.getDirectorById", id);
	}

	public Long addDirector(Director director) {
		return (Long) getSqlMapClientTemplate().insert("director.addDirector", director);
	}

	public void updateDirector(Director director) {
		getSqlMapClientTemplate().update("director.updateDirector", director);
	}

	public void deleteDirectorById(Long id) {
		getSqlMapClientTemplate().delete("director.deleteDirectorById", id);
	}

}