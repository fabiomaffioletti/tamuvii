package com.tamuvii.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "localized_movie_data", catalog = "tamuvii")
public class LocalizedMovieData implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559009307L;
	
	private String id;
	private String locale;
	private String title;
	private String plot;
	private Movie movie;
	
	public LocalizedMovieData() {
		
	}
	
	public LocalizedMovieData(String id) {
		this.id = id;
	}
	
	
	
	@Id
	@Column( name = "localized_movie_data", nullable = false, length = 45  )
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column( nullable = false, length = 5  )
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@Column( name = "title", length = 200  )
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column( name = "plot", length = 70000 )
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name = "movie" )
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}	
}