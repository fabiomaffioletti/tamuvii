package com.tamuvii.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_to_movie")
public class UserMovie {
	
	@Embeddable
	public static class Id implements Serializable {
		
		@Column(name="userid")
		private Long userId;
		@Column(name="movie_id")
		private Long movieId;
		
		public Id() {}

		public Id(Long userId, Long movieId) {
			this.userId = userId;
			this.movieId = movieId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((movieId == null) ? 0 : movieId.hashCode());
			result = prime * result
					+ ((userId == null) ? 0 : userId.hashCode());
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
			Id other = (Id) obj;
			if (movieId == null) {
				if (other.movieId != null)
					return false;
			} else if (!movieId.equals(other.movieId))
				return false;
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			return true;
		}

	}
	
	
	@EmbeddedId
	private Id id = new Id();
	
	@Column(name="date_added")
	private Date dateAdded;
	@Column(name="date_viewed")
	private Date dateViewed;
	@Column(name="mark")
	private Integer mark;
	
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "movie_id", insertable = false, updatable = false)
	private Movie movie;
	
	public UserMovie() {}
	
	
	
	public UserMovie(Date dateAdded, Date dateViewed, Integer mark, User user, Movie movie) {
		super();
		this.dateAdded = dateAdded;
		this.dateViewed = dateViewed;
		this.mark = mark;
		this.user = user;
		this.movie = movie;
		
		this.id.userId = user.getId();
		this.id.movieId = movie.getId();
		
		user.getUserMovies().add(this);
		movie.getUserMovies().add(this);
		
	}


	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Movie getMovie() {
		return movie;
	}



	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
}
