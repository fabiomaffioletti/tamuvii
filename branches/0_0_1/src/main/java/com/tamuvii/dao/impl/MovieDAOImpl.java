package com.tamuvii.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ReviewItem;

public class MovieDAOImpl extends SqlMapClientDaoSupport implements MovieDAO {

	@SuppressWarnings("unchecked")
	public List<MovieItem> getAll(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("movie.getAll", queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getAllCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("movie.getAllCount", queryMap);
	}

	public Movie getMovieById(Long id) {
		return (Movie) getSqlMapClientTemplate().queryForObject("movie.getMovieById", id);
	}

	public Long addMovie(Movie movie) {
		return (Long) getSqlMapClientTemplate().insert("movie.addMovie", movie);
	}

	public void updateMovie(Movie movie) {
		getSqlMapClientTemplate().update("movie.updateMovie", movie);
	}

	public void deleteMovieById(Long id) {
		getSqlMapClientTemplate().delete("movie.deleteMovieById", id);
	}

	public MovieItem getMovieItem(Long id) {
		return (MovieItem) getSqlMapClientTemplate().queryForObject("movie.getMovieItem", id);
	}

	@SuppressWarnings("unchecked")
	public Map getMovieItemMarks(Long id) {
		return (Map) getSqlMapClientTemplate().queryForMap("movie.getMovieItemMarks", id, "mark");
	}

	@SuppressWarnings("unchecked")
	public List<MovieItem> getMoviesByDirector(Map queryMap) {
		return (List<MovieItem>) getSqlMapClientTemplate().queryForList("movie.getMoviesByDirector", queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getMoviesByDirectorCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("movie.getMoviesByDirectorCount", queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<ReviewItem> getReviewItemsByMovie(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("review.getReviewItemsByMovie", queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieItem> getLastAdded(Integer num) {
		return getSqlMapClientTemplate().queryForList("movie.getLastAdded", num);
	}
	
	
	
	/*
	 * ADMIN METHODS
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public List<Movie> getAllAdmin(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("movie.getAllAdmin", queryMap);
	}
	public void updateMovieImage(Movie movie) {
		getSqlMapClientTemplate().update("movie.updateMovieImage", movie);
	}
	
	
}