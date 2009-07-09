package com.tamuvii.pojo.queryfilter;

public class SocialMovieFilter {
	
	private Integer movie;
	private String username;
	private String[] filter;
	
	
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
	public String[] getFilter() {
		return filter;
	}
	public void setFilter(String[] filter) {
		this.filter = filter;
	}
	
}