package com.tamuvii.pojo.queryfilter;

public class PersonalMovieFilterMap {
	
	private Integer movie;
	private String username;
	
	public PersonalMovieFilterMap(Integer movie, String username) {
		super();
		this.movie = movie;
		this.username = username;
	}

	public Integer getMovie() {
		return movie;
	}
	public void setMovie(Integer movie) {
		this.movie = movie;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}