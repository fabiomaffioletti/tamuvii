package com.tamuvii.model;

import java.util.Date;

public class Review {
    private Long user;
    private Long movie;
    private String title;
    private String text;
    private Integer positive;
    private Integer negative;
    private Date dateAdded;
    
    
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPositive() {
		return positive;
	}
	public void setPositive(Integer positive) {
		this.positive = positive;
	}
	public Integer getNegative() {
		return negative;
	}
	public void setNegative(Integer negative) {
		this.negative = negative;
	}
	public Long getMovie() {
		return movie;
	}
	public void setMovie(Long movie) {
		this.movie = movie;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
    
}