package com.tamuvii.pojo.queryfilter;

public class PersonalMovieFilterMap {
	
	private Integer movieId;
	private String username;
	
	public PersonalMovieFilterMap(Integer movieId, String username) {
		super();
		this.movieId = movieId;
		this.username = username;
	}

	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}