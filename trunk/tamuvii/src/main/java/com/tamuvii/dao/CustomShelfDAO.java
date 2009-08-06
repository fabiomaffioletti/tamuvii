package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;
import com.tamuvii.pojo.queryfilter.ShelfItemFilter;

public interface CustomShelfDAO {
	
	public List<ShelfItem> getShelfByUsername(String username);
	
	public List<ShelfItem> getWishedMoviesByUsername(String username);
	
	public List<Integer> getPersonalMoviesIds(String username);
	
	public List<Integer> getShelfMoviesIds(String username);
	
	public List<Integer> getWishedMoviesIds(String username);
	
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(String username);
	
	public List<ShelfDirectorReport> getShelfDirectorReport(ShelfDirectorReportFilter sdrf);
	
	public List<ShelfItem> getShelfByFilter(ShelfItemFilter sif);
	public Integer getShelfCountByFilter(ShelfItemFilter sif);
	
}