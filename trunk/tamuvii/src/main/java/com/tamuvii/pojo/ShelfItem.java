package com.tamuvii.pojo;

import java.util.Date;


public class ShelfItem {
	
	private Integer movie;
	private String duration;
	private String originalTitle;
	private String originalPlot;
	private String localizedTitle;
	private String localizedPlot;
	private Integer directorId;
	private String director;
	private Date releaseDate;
	private Date dateAdded;
	private Date dateViewed;
	private Integer mark;
	private Integer numUsers;
	private String originalImage;
	private String localizedImage;
	private Integer review;
	private String reviewTitle;
	private String reviewText;
	
	
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public String getOriginalImage() {
		return originalImage;
	}
	public void setOriginalImage(String originalImage) {
		this.originalImage = originalImage;
	}
	public String getLocalizedImage() {
		return localizedImage;
	}
	public void setLocalizedImage(String localizedImage) {
		this.localizedImage = localizedImage;
	}
	public String getOriginalPlot() {
		return originalPlot;
	}
	public void setOriginalPlot(String originalPlot) {
		this.originalPlot = originalPlot;
	}
	public String getLocalizedTitle() {
		return localizedTitle;
	}
	public void setLocalizedTitle(String localizedTitle) {
		this.localizedTitle = localizedTitle;
	}
	public String getLocalizedPlot() {
		return localizedPlot;
	}
	public void setLocalizedPlot(String localizedPlot) {
		this.localizedPlot = localizedPlot;
	}
	public Integer getNumUsers() {
		return numUsers;
	}
	public void setNumUsers(Integer numUsers) {
		this.numUsers = numUsers;
	}
	public Integer getDirectorId() {
		return directorId;
	}
	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}
	public Integer getMovie() {
		return movie;
	}
	public void setMovie(Integer movie) {
		this.movie = movie;
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