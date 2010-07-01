package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.Movie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ReviewItem;

public interface MovieDAO {
	
	public List<MovieItem> getAll(Map queryMap);
	public Integer getAllCount(Map queryMap);
	public Movie getMovieById(Long id);
	
	public Long addMovie(Movie movie);
	public void updateMovie(Movie movie);
	public void deleteMovieById(Long id);

	public MovieItem getMovieItem(Long id);
	public Map getMovieItemMarks(Long id);
	
	public List<MovieItem> getMoviesByDirector(Map queryMap);
	public Integer getMoviesByDirectorCount(Map queryMap);
	
	public List<ReviewItem> getReviewItemsByMovie(Map queryMap);
	
	
	public List<Movie> getAllAdmin(Map queryMap);
	public void updateMovieImage(Movie movie);
	
	public List<MovieItem> getLastAdded(Integer num);
}