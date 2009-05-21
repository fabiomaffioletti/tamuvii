package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomRelationshipDAO;
import com.tamuvii.pojo.UserNeighbor;

public class CustomRelationshipDAOImpl extends SqlMapClientDaoSupport implements CustomRelationshipDAO {
	
	public CustomRelationshipDAOImpl() {
		super();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<UserNeighbor> getUserFriends(String username) {
		return getSqlMapClientTemplate().queryForList("custom_relationship.getUserFriends", username);
	}

	@SuppressWarnings("unchecked")
	public List<UserNeighbor> getUserNeighborhoods(String username) {
		return getSqlMapClientTemplate().queryForList("custom_relationship.getUserNeighborhoods", username);
	}

	public UserNeighbor getUserPublicInfo(String username) {
		return (UserNeighbor) getSqlMapClientTemplate().queryForObject("custom_relationship.getUserPublicInfo", username);
	}

	
}