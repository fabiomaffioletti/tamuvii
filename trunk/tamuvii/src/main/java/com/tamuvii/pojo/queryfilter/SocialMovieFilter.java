package com.tamuvii.pojo.queryfilter;

public class SocialMovieFilter {
	
	private Integer movie;
	private String username;
	private String[] filter;
	private Integer from;
	private Integer to;
	private boolean rand;
	
	
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public boolean isRand() {
		return rand;
	}
	public void setRand(boolean rand) {
		this.rand = rand;
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
	public String[] getFilter() {
		return filter;
	}
	public void setFilter(String[] filter) {
		this.filter = filter;
	}
	
}