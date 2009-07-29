package com.tamuvii.pojo;

import java.util.Date;

import com.tamuvii.model.Review;

public class PersonalMovie {
	
	private Integer movie;
	private String duration;
	private String originalTitle;
	private String originalPlot;
	private String localizedTitle;
	private String localizedPlot;
	private String originalImage;
	private String originalCountry;
	private String originalTrailer;
	private String localizedImage;
	private String localizedCountry;
	private String localizedTrailer;
	private Integer directorId;
	private String director;
	private Date releaseDate;
	private Date dateAdded;
	private Date dateViewed;
	private Integer mark;
	private Review review;
	
	public PersonalMovie() {
		review = new Review();
	}
	
	
	public String getOriginalCountry() {
		return originalCountry;
	}
	public void setOriginalCountry(String originalCountry) {
		this.originalCountry = originalCountry;
	}
	public String getOriginalTrailer() {
		return originalTrailer;
	}
	public void setOriginalTrailer(String originalTrailer) {
		this.originalTrailer = originalTrailer;
	}
	public String getLocalizedCountry() {
		return localizedCountry;
	}
	public void setLocalizedCountry(String localizedCountry) {
		this.localizedCountry = localizedCountry;
	}
	public String getLocalizedTrailer() {
		return localizedTrailer;
	}
	public void setLocalizedTrailer(String localizedTrailer) {
		this.localizedTrailer = localizedTrailer;
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
	public Integer getMovie() {
		return movie;
	}
	public void setMovie(Integer movie) {
		this.movie = movie;
	}
	public Integer getDirectorId() {
		return directorId;
	}
	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
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