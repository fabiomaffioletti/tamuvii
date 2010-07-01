package com.tamuvii.dao.impl;

import java.util.List;

import com.tamuvii.dao.RoleDAO;
import com.tamuvii.model.Role;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RoleDAOImpl extends SqlMapClientDaoSupport implements RoleDAO {

	public Role getRoleByName(String name) {
		return (Role) getSqlMapClientTemplate().queryForObject("role.getRoleByName", name);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAll() {
		return getSqlMapClientTemplate().queryForList("role.getAll");
	}

	public Role getRoleById(Long id) {
		return (Role) getSqlMapClientTemplate().queryForObject("role.getRoleById", id);
	}

}