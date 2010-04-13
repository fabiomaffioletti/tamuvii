package com.tamuvii.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tamuvii.dao.GenreDAO;
import com.tamuvii.dao.MovieDAO;
import com.tamuvii.model.Movie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ReviewItem;
import com.tamuvii.service.MovieManager;

public class MovieManagerImpl implements MovieManager {
	private MovieDAO movieDao = null;
	private GenreDAO genreDao = null;
	
	public void setGenreDao(GenreDAO genreDao) {
		this.genreDao = genreDao;
	}
	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}


	@SuppressWarnings("unchecked")
	public List<MovieItem> getAll(String filter, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return movieDao.getAll(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getAllCount(String filter) {
		Map queryMap = new HashMap();
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return movieDao.getAllCount(queryMap);
	}



	public Movie getMovieById(Long id) {
		Movie movie = movieDao.getMovieById(id);
		movie.setGenres(genreDao.getMovieGenres(id));
		return movie;
	}

	public List<MovieItem> getLastAdded(Integer num) {
		return movieDao.getLastAdded(num);
	}


	public Long addMovie(Movie movie) {
		return movieDao.addMovie(movie);
	}
	public Long addMovie(String title, String plot, Integer duration, String image, Integer year, Long director) {
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setDirector(director);
		movie.setDuration(duration);
		movie.setPlot(plot);
		movie.setYear(year);
		movie.setImage(image);
		return addMovie(movie);
	}


	public void udpateMovie(Movie movie) {
		movieDao.updateMovie(movie);
	}


	public void deleteMovie(Long id) {
		movieDao.deleteMovieById(id);
	}


	@SuppressWarnings("unchecked")
	public MovieItem getMovieItem(Long id) {
		MovieItem movieItem = movieDao.getMovieItem(id);
		movieItem.setMarks(movieDao.getMovieItemMarks(id));
		return movieItem;
	}


	@SuppressWarnings("unchecked")
	public List<MovieItem> getMoviesByDirector(Long id, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("id", id);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return movieDao.getMoviesByDirector(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getMoviesByDirectorCount(Long id) {
		Map queryMap = new HashMap();
		queryMap.put("id", id);
		return movieDao.getMoviesByDirectorCount(queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<ReviewItem> getReviewItemsByMovie(Long id, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("movie", id);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return movieDao.getReviewItemsByMovie(queryMap);
	}


	
	/*
	 * ADMIN METHODS
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Movie> getAllAdmin(String filter) {
		Map queryMap = new HashMap();
		queryMap.put("filter", StringUtils.isNotEmpty(filter)?filter.split(" "):null); 
		return movieDao.getAllAdmin(queryMap);
	}
	public void updateMovie(Movie movie) {
		movieDao.updateMovie(movie);
	}
	public void updateMovieImage(Movie movie) {
		movieDao.updateMovieImage(movie);
	}

}