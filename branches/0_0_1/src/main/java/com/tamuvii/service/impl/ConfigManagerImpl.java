package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.ConfigDAO;
import com.tamuvii.model.Config;
import com.tamuvii.service.ConfigManager;

public class ConfigManagerImpl implements ConfigManager {
	private ConfigDAO configDao = null;

	public void setConfigDao(ConfigDAO configDao) {
		this.configDao = configDao;
	}

	public List<Config> getAll() {
		return configDao.getAll();
	}

	public Integer getIntegerValueById(Long id) {
		return configDao.getIntegerValueById(id);
	}

	public Integer getIntegerValueByKey(String key) {
		return configDao.getIntegerValueByKey(key);
	}

	public String getStringValueById(Long id) {
		return configDao.getStringValueById(id);
	}

	public String getStringValueByKey(String key) {
		return configDao.getStringValueByKey(key);
	}

}
