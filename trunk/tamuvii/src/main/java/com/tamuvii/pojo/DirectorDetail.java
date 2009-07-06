package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.model.Director;
import com.tamuvii.model.Movie;

public class DirectorDetail {
	
	private Director director;
	private Integer numMovies;
	private List<Movie> movies;

	public Integer getNumMovies() {
		return numMovies;
	}
	public void setNumMovies(Integer numMovies) {
		this.numMovies = numMovies;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
}