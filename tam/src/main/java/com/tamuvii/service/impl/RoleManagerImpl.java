package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.RoleDAO;
import com.tamuvii.model.Role;
import com.tamuvii.service.RoleManager;

public class RoleManagerImpl implements RoleManager {
	private RoleDAO roleDao = null;

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public List<Role> getAll() {
		return roleDao.getAll();
	}

	public Role getRoleByName(String name) {
		return roleDao.getRoleByName(name);
	}

	public Role getRoleById(String id) {
		return roleDao.getRoleById(Long.parseLong(id));
	}

}