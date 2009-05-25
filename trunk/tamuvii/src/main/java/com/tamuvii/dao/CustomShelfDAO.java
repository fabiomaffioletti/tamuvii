package com.tamuvii.dao;

import java.util.List;

import org.json.JSONException;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;

public interface CustomShelfDAO {
	
	public List<ShelfItem> getShelfByUsername(String username);
	
	public List<ShelfItem> getWishedMoviesByUsername(String username);
	
	public List<Integer> getPersonalMoviesIds(String username);
	
	public List<Integer> getShelfMoviesIds(String username);
	
	public List<Integer> getWishedMoviesIds(String username);
	
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(String username);
	
	public List<ShelfDirectorReport> getShelfDirectorReport(ShelfDirectorReportFilter sdrf);
	
	public String JSONShelfDirectorReport(String username, Integer x, Integer y) throws JSONException;
	
}