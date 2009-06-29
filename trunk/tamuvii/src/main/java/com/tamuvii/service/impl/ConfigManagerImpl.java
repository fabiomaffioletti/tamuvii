package com.tamuvii.service.impl;

import com.tamuvii.dao.ConfigDAO;
import com.tamuvii.service.ConfigManager;

public class ConfigManagerImpl implements ConfigManager {
	private ConfigDAO configDao = null;

	public void setConfigDao(ConfigDAO configDao) {
		this.configDao = configDao;
	}


	public String getString(String key) {
		return configDao.selectByPrimaryKey(key).getConfigvalue();
	}
}