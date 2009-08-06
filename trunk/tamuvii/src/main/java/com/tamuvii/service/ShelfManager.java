package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.ShelfItem;

public interface ShelfManager {

	public List<ShelfDirectorReport> getShelfDirectorReport(String username, Integer from, Integer to, String orderAttribute);
	
	//public List<ShelfItem> getShelfByFilter(String username, Integer director, String orderAttribute, String orderCriteria);
	
	public List<ShelfItem> getShelfByFilter(String username, Integer director, String orderAttribute, String orderCriteria, Integer page) throws Exception;
	
}