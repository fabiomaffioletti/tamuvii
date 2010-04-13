package com.tamuvii.model;

import java.util.Date;

public class UserMovie {
	private Long user;
    private Long movie;
    private Date dateAdded;
    private Date dateViewed;
    private Integer mark;
    private Integer wishlist;
    
    
	public Date getDateViewed() {
		return dateViewed;
	}
	public void setDateViewed(Date dateViewed) {
		this.dateViewed = dateViewed;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getMovie() {
		return movie;
	}
	public void setMovie(Long movie) {
		this.movie = movie;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public Integer getWishlist() {
		return wishlist;
	}
	public void setWishlist(Integer wishlist) {
		this.wishlist = wishlist;
	}
    
}