package com.tamuvii.service;

import java.util.List;

import org.json.JSONException;

import com.tamuvii.pojo.ShelfDirectorReport;

public interface ShelfManager {

	public List<ShelfDirectorReport> getShelfDirectorReport(String username);
	
	public String getJSONShelfDirectorReport(String username, Integer x, Integer y) throws JSONException;
	
}