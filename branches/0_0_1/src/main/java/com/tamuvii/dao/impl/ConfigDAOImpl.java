package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.ConfigDAO;
import com.tamuvii.model.Config;

public class ConfigDAOImpl extends SqlMapClientDaoSupport implements ConfigDAO {

	@SuppressWarnings("unchecked")
	public List<Config> getAll() {
		return getSqlMapClientTemplate().queryForList("config.getAll");
	}

	public String getStringValueById(Long id) {
		return (String) getSqlMapClientTemplate().queryForObject("config.getStringValueById", id);
	}

	public String getStringValueByKey(String key) {
		return (String) getSqlMapClientTemplate().queryForObject("config.getStringValueByKey", key);
	}
	
	public Integer getIntegerValueById(Long id) {
		return (Integer) getSqlMapClientTemplate().queryForObject("config.getIntegerValueById", id);
	}

	public Integer getIntegerValueByKey(String key) {
		return (Integer) getSqlMapClientTemplate().queryForObject("config.getIntegerValueByKey", key);
	}

}