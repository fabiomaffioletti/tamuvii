package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.model.Role;

public class RoleDaoTest extends ApplicationTest {
	private RoleDAO roleDao = null;

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	
	public void testGetAll() {
		List<Role> roles = roleDao.getAll();
		assertNotNull(roles);
		assertTrue(roles.size() == 2);
	}
	
	public void testGetRoleByName() {
		String rolename = "ROLE_ADMIN";
		Role role = roleDao.getRoleByName(rolename);
		assertNotNull(role);
	}
	
	public void testGetRoleById() {
		Long id = 2L;
		Role role = roleDao.getRoleById(id);
		assertNotNull(role);
		
		id = -1L;
		role = roleDao.getRoleById(id);
		assertNull(role);
	}
	
}