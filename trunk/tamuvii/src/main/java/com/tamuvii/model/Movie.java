package com.tamuvii.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;

@Entity
@Table(name = "movie", catalog = "tamuvii")
public class Movie implements Cloneable, Serializable {
	private static final long serialVersionUID = -559009206L;

	private Director director;
	private String duration;
	private Long id = 0L; // init for hibernate bug workaround
	private String originalTitle;
	private Date releaseDate;
	
	private Set<Review> review = new HashSet<Review>();
	
	private Set<UserMovie> userMovies = new HashSet<UserMovie>();
	
	@OneToMany(mappedBy="movie")
	public Set<UserMovie> getUserMovies() {
		return userMovies;
	}
	public void setUserMovies(Set<UserMovie> userMovies) {
		this.userMovies = userMovies;
	}
	
	
	public Movie() {
		// Default constructor
	} 
	public Movie(Long id) {
		this.id = id;
	}
	
	@ManyToOne()
	@JoinColumn(name = "director", nullable = true  )
	public Director getDirector() {
		return this.director;
		
	}
	public void setDirector(final Director director) {
		this.director = director;
	}
	
	
	@Length(max=45)
	@Column( length = 45  )
	public String getDuration() {
		return this.duration;
		
	}
	public void setDuration(final String duration) {
		this.duration = duration;
	}


	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "movie"  )
	public Long getId() {
		return this.id;
		
	}
	public void setId(final Long id) {
		this.id = id;
	}
	

	@Length(max=200)
	@Column( name = "original_title", length = 200  )
	public String getOriginalTitle() {
		return this.originalTitle;
		
	}
	
	public void setOriginalTitle(final String originalTitle) {
		this.originalTitle = originalTitle;
	}

	@Column( name = "release_date"  )
	public Date getReleaseDate() {
		return this.releaseDate;
		
	}
	public void setReleaseDate(final Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "movie_to_review",
		joinColumns = {@JoinColumn(name = "movie")},
		inverseJoinColumns = {@JoinColumn(name = "review")}
	)
	public Set<Review> getReview() {
		return this.review;
		
	}
	
	public void addReview(Review review) {
		getReview().add(review);
	}

  
    /**  
     * Set the value related to the column: review.
	 * @param review the review value you wish to set
	 */
	public void setReview(final Set<Review> review) {
		this.review = review;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((director == null) ? 0 : director.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((originalTitle == null) ? 0 : originalTitle.hashCode());
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (originalTitle == null) {
			if (other.originalTitle != null)
				return false;
		} else if (!originalTitle.equals(other.originalTitle))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}

	
}