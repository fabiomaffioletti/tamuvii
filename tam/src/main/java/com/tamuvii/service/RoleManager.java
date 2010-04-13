package com.tamuvii.service;

import com.tamuvii.model.Role;

import java.util.List;

public interface RoleManager {
	
	public List<Role> getAll();
	public Role getRoleById(String id);
	public Role getRoleByName(String name);
	
}