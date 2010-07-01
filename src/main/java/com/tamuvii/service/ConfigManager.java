package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Config;

public interface ConfigManager {
	
	public List<Config> getAll();
	
	public String getStringValueById(Long id);
	public String getStringValueByKey(String key);
	
	public Integer getIntegerValueById(Long id);
	public Integer getIntegerValueByKey(String key);
	
}