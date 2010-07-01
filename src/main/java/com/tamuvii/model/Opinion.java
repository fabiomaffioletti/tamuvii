package com.tamuvii.model;

import java.util.Date;

public class Opinion {
	private Long id;
    private Long user;
    private Long reviewer;
    private Long movie;
    private String text;
    private Date dateAdded;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getReviewer() {
		return reviewer;
	}
	public void setReviewer(Long reviewer) {
		this.reviewer = reviewer;
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