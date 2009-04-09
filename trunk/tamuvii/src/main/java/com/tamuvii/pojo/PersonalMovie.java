package com.tamuvii.pojo;

import java.util.Date;

import com.tamuvii.model.Review;

public class PersonalMovie {
	
	private Integer movieId;
	private String duration;
	private String originalTitle;
	private String director;
	private Date releaseDate;
	private Date dateAdded;
	private Date dateViewed;
	private Integer mark;
	private Review review;
	
	public PersonalMovie() {
		review = new Review();
	}
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Date getDateViewed() {
		return dateViewed;
	}
	public void setDateViewed(Date dateViewed) {
		this.dateViewed = dateViewed;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
}