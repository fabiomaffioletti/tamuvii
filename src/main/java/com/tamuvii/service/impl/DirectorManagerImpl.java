package com.tamuvii.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tamuvii.dao.DirectorDAO;
import com.tamuvii.model.Director;
import com.tamuvii.service.DirectorManager;

public class DirectorManagerImpl implements DirectorManager {
	private DirectorDAO directorDao = null;

	public void setDirectorDao(DirectorDAO directorDao) {
		this.directorDao = directorDao;
	}



	@SuppressWarnings("unchecked")
	public List<Director> getAll(String filter, Integer from, Integer to) {
		String[] splittedFilter = StringUtils.isNotEmpty(filter)?filter.split(" "):null;
		Map queryMap = new HashMap();
		queryMap.put("filter", splittedFilter);
		queryMap.put("from", from);
		queryMap.put("to", to);
		queryMap.put("order", "order by surname asc");
		return directorDao.getAll(queryMap);
	}



	public Director getDirectorById(Long id) {
		return directorDao.getDirectorById(id);
	}



	public Long addDirector(Director director) {
		return directorDao.addDirector(director);
	}
	public Long addDirector(String name, String surname, String nickname) {
		Director director = new Director();
		director.setName(name);
		director.setSurname(surname);
		director.setNickname(nickname);
		return addDirector(director);
	}


	public void udpateDirector(Director director) {
		directorDao.updateDirector(director);
	}


	public void deleteDirector(Long id) {
		directorDao.deleteDirectorById(id);
	}

}