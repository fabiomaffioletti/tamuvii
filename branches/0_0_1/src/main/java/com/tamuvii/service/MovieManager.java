package com.tamuvii.service;

import java.util.List;

import com.tamuvii.model.Movie;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ReviewItem;

public interface MovieManager {
	
	public List<MovieItem> getAll(String filter, Integer from, Integer to);
	public Integer getAllCount(String filter);
	
	public Movie getMovieById(Long id);
	
	public Long addMovie(Movie movie);
	public Long addMovie(String title, String plot, Integer duration, String image, Integer year, Long director);
	public void udpateMovie(Movie movie);
	public void deleteMovie(Long id);
	
	
	public MovieItem getMovieItem(Long id);
	public List<ReviewItem> getReviewItemsByMovie(Long id, Integer from, Integer to);
	
	public List<MovieItem> getMoviesByDirector(Long id, Integer from, Integer to);
	public Integer getMoviesByDirectorCount(Long id);
	
	
	public List<Movie> getAllAdmin(String filter);
	public void updateMovie(Movie movie);
	public void updateMovieImage(Movie movie);
	
	
	public List<MovieItem> getLastAdded(Integer num);
	
}