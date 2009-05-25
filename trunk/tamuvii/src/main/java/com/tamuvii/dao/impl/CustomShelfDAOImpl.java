package com.tamuvii.dao.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomShelfDAO;
import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.ShelfDirectorReport;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.queryfilter.ShelfDirectorReportFilter;
import com.tamuvii.util.TamuviiConstants;

public class CustomShelfDAOImpl extends SqlMapClientDaoSupport implements CustomShelfDAO {
	
	public CustomShelfDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<ShelfItem> getShelfByUsername(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getShelfByUsername", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<ShelfItem> getWishedMoviesByUsername(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getWishedMoviesByUsername", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getPersonalMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getPersonalMoviesIds", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getShelfMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getShelfMoviesIds", username);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getWishedMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getWishedMoviesIds", username);
	}

	@SuppressWarnings("unchecked")
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(String username) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getPersonalMoviesIdsAndWishedFlags", username);
	}

	@SuppressWarnings("unchecked")
	public List<ShelfDirectorReport> getShelfDirectorReport(ShelfDirectorReportFilter sdrf) {
		return getSqlMapClientTemplate().queryForList("custom_shelf.getShelfDirectorReport", sdrf);
	}
	

	public Integer getShelfDirectorReportCount(String username) {
		return (Integer) getSqlMapClientTemplate().queryForObject("custom_shelf.getShelfDirectorReportCount", username);
	}
	
	
	public String JSONShelfDirectorReport(String username, Integer x, Integer y) throws JSONException {
		ShelfDirectorReportFilter sdrf = new ShelfDirectorReportFilter();
		sdrf.setUsername(username);
		sdrf.setFrom(x);
		sdrf.setTo(y);
		
		List<ShelfDirectorReport> sdrs = getShelfDirectorReport(sdrf);
		JSONArray itemList = new JSONArray();
		for(ShelfDirectorReport sdr : sdrs) {
			JSONObject i = new JSONObject();
			i.put("director", sdr.getDirector());
			i.put("name", sdr.getName());
			i.put("surname", sdr.getSurname());
			i.put("aka", sdr.getAka());
			i.put("numMovies", sdr.getNumMovies());
			itemList.put(i);
		}

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("size", itemList.length());
		jsonObj.put("itemList", itemList);
		jsonObj.put("last", getShelfDirectorReportCount(username) - x <= TamuviiConstants.SHELF_DIRECTOR_REPORT_RECORD_PER_PAGE);
		
		return jsonObj.toString();
	}

}