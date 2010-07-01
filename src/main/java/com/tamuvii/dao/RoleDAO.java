package com.tamuvii.dao;

import com.tamuvii.model.Role;

import java.util.List;

public interface RoleDAO {
	
	public List<Role> getAll();
	public Role getRoleById(Long id);
	public Role getRoleByName(String name);

}