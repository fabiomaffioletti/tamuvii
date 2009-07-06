package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.model.Director;

public class DirectorDetail {
	
	private Director director;
	private Integer numMovies;
	private List<SocialMovie> movies;

	
	public List<SocialMovie> getMovies() {
		return movies;
	}
	public void setMovies(List<SocialMovie> movies) {
		this.movies = movies;
	}
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
	
}