package com.tamuvii.pojo;

import java.util.Date;
import java.util.List;

public class SocialMovie {
	
	private Integer movie;
	private String duration;
	private String originalTitle;
	private String originalPlot;
	private String localizedTitle;
	private String localizedPlot;
	private String originalImage;
	private String localizedImage;
	private Integer directorId;
	private String director;
	private Date releaseDate;
	private Integer numReviews;
	private List<DetailedReview> detailedReviews;
	private Float avgMark;
	private List<MovieUser> movieUsers;
	
	
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
	
	public List<MovieUser> getMovieUsers() {
		return movieUsers;
	}
	public void setMovieUsers(List<MovieUser> movieUsers) {
		this.movieUsers = movieUsers;
	}
	public List<DetailedReview> getDetailedReviews() {
		return detailedReviews;
	}
	public void setDetailedReviews(List<DetailedReview> detailedReviews) {
		this.detailedReviews = detailedReviews;
	}
	public Float getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(Float avgMark) {
		this.avgMark = avgMark;
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
	public Integer getNumReviews() {
		return numReviews;
	}
	public void setNumReviews(Integer numReviews) {
		this.numReviews = numReviews;
	}

}