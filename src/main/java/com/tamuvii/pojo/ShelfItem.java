package com.tamuvii.pojo;

import com.tamuvii.model.Director;
import com.tamuvii.model.Movie;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserMovie;

public class ShelfItem {
	private UserMovie userMovie;
	private Movie movie;
	private Director director;
	private Review review;
	private Integer belonging;
	
	
	public Integer getBelonging() {
		return belonging;
	}
	public void setBelonging(Integer belonging) {
		this.belonging = belonging;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public UserMovie getUserMovie() {
		return userMovie;
	}
	public void setUserMovie(UserMovie userMovie) {
		this.userMovie = userMovie;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}