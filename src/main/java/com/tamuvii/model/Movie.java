package com.tamuvii.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Movie {
	private Long id;
    private String title;
    private String plot;
    private Integer duration;
    private String image;
    private Integer year;
    private Long director;
    private Date dateAdded;
    private Set<Genre> genres = new HashSet<Genre>();
    
   
	public Set<Genre> getGenres() {
		return genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Long getDirector() {
		return director;
	}
	public void setDirector(Long director) {
		this.director = director;
	}
    
}