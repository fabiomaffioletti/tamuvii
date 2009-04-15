package com.tamuvii.pojo;

import java.util.Date;


public class ShelfItem {
	
	private Integer movie;
	private String duration;
	private String originalTitle;
	private Integer directorId;
	private String director;
	private Date releaseDate;
	private Date dateAdded;
	private Date dateViewed;
	private Integer mark;
	
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