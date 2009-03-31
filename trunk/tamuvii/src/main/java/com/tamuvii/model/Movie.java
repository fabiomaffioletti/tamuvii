package com.tamuvii.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;


/** 
 * Object mapping for hibernate-handled table: movie.
 * @author autogenerated
 */

@Entity
@Table(name = "movie", catalog = "tamuvii")
public class Movie implements Cloneable, Serializable, IMovie {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559009206L;
	
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Director director;
	/** Field mapping. */
	private String duration;
	/** Field mapping. */
	private Integer id = 0; // init for hibernate bug workaround
	/** Field mapping. */
	private String originalTitle;
	/** Field mapping. */
	private Date releaseDate;
	/** Field mapping. */
	private Set<Actor> actor = new HashSet<Actor>();

	/** Field mapping. */
	private Set<LocalizedData> date = new HashSet<LocalizedData>();

	/** Field mapping. */
	private Set<Genre> genri = new HashSet<Genre>();

	/** Field mapping. */
	private List<Review> review = new ArrayList<Review>();


	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Movie() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Movie(Integer id) {
		this.id = id;
	}
	
 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Movie.class;
	}
 

    /**
     * Return the value associated with the column: director.
	 * @return A Director object (this.director)
	 */
	@ManyToOne()
	@JoinColumn(name = "director", nullable = true  )
	public Director getDirector() {
		return this.director;
		
	}
	

  
    /**  
     * Set the value related to the column: director.
	 * @param director the director value you wish to set
	 */
	public void setDirector(final Director director) {
		this.director = director;
	}

    /**
     * Return the value associated with the column: duration.
	 * @return A String object (this.duration)
	 */
	@Length(max=45)
	@Column( length = 45  )
	public String getDuration() {
		return this.duration;
		
	}
	

  
    /**  
     * Set the value related to the column: duration.
	 * @param duration the duration value you wish to set
	 */
	public void setDuration(final String duration) {
		this.duration = duration;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "movie"  )
	public Integer getId() {
		return this.id;
		
	}
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Integer id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0) &&
				(id != null) &&
				(this.hashCode != null) ) {
			SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

    /**
     * Return the value associated with the column: originalTitle.
	 * @return A String object (this.originalTitle)
	 */
	@Length(max=200)
	@Column( name = "original_title", length = 200  )
	public String getOriginalTitle() {
		return this.originalTitle;
		
	}
	

  
    /**  
     * Set the value related to the column: originalTitle.
	 * @param originalTitle the originalTitle value you wish to set
	 */
	public void setOriginalTitle(final String originalTitle) {
		this.originalTitle = originalTitle;
	}

    /**
     * Return the value associated with the column: releaseDate.
	 * @return A Date object (this.releaseDate)
	 */
	@Column( name = "release_date"  )
	public Date getReleaseDate() {
		return this.releaseDate;
		
	}
	

  
    /**  
     * Set the value related to the column: releaseDate.
	 * @param releaseDate the releaseDate value you wish to set
	 */
	public void setReleaseDate(final Date releaseDate) {
		this.releaseDate = releaseDate;
	}

    /**
     * Return the value associated with the column: actor.
	 * @return A Set&lt;Actor&gt; object (this.actor)
	 */
	@ManyToMany
	@JoinTable(
		name = "movie_to_actor",
		catalog = "tamuvii",
		joinColumns = {@JoinColumn(name = "movie")},
		inverseJoinColumns = {@JoinColumn(name = "actor")}
	)
	public Set<Actor> getActor() {
		return this.actor;
		
	}
	
	/**
	 * Adds a bi-directional link of type Actor to the set.
	 * 
	 * @param actor item to add
	 */
	public void addActor(Actor actor) {
		actor.getMovie().add(this);
		this.actor.add(actor);
	}

  
    /**  
     * Set the value related to the column: actor.
	 * @param actor the actor value you wish to set
	 */
	public void setActor(final Set<Actor> actor) {
		this.actor = actor;
	}

    /**
     * Return the value associated with the column: data.
	 * @return A Set&lt;LocalizedData&gt; object (this.data)
	 */
	@ManyToMany
	@JoinTable(
		name = "movie_to_data",
		catalog = "tamuvii",
		joinColumns = {@JoinColumn(name = "movie")},
		inverseJoinColumns = {@JoinColumn(name = "localized_data")}
	)
	public Set<LocalizedData> getDate() {
		return this.date;
		
	}
	
	/**
	 * Adds a bi-directional link of type Data to the set.
	 * 
	 * @param data item to add
	 */
	public void addData(LocalizedData data) {
		data.getMovie().add(this);
		this.date.add(data);
	}

  
    /**  
     * Set the value related to the column: data.
	 * @param data the data value you wish to set
	 */
	public void setDate(final Set<LocalizedData> data) {
		this.date = data;
	}

    /**
     * Return the value associated with the column: genre.
	 * @return A Set&lt;Genre&gt; object (this.genre)
	 */
	@ManyToMany
	@JoinTable(
		name = "movie_to_genre",
		catalog = "tamuvii",
		joinColumns = {@JoinColumn(name = "movie")},
		inverseJoinColumns = {@JoinColumn(name = "genre")}
	)
	public Set<Genre> getGenri() {
		return this.genri;
		
	}
	
	/**
	 * Adds a bi-directional link of type Genre to the set.
	 * 
	 * @param genre item to add
	 */
	public void addGenre(Genre genre) {
		genre.getMovie().add(this);
		this.genri.add(genre);
	}

  
    /**  
     * Set the value related to the column: genre.
	 * @param genre the genre value you wish to set
	 */
	public void setGenri(final Set<Genre> genre) {
		this.genri = genre;
	}

    /**
     * Return the value associated with the column: review.
	 * @return A Set&lt;Review&gt; object (this.review)
	 */
	@ManyToMany
	@JoinTable(
		name = "movie_to_review",
		catalog = "tamuvii",
		joinColumns = {@JoinColumn(name = "movie")},
		inverseJoinColumns = {@JoinColumn(name = "review")}
	)
	public List<Review> getReview() {
		return this.review;
		
	}
	
	/**
	 * Adds a bi-directional link of type Review to the set.
	 * 
	 * @param review item to add
	 */
	public void addReview(Review review) {
		review.getMovie().add(this);
		this.review.add(review);
	}

  
    /**  
     * Set the value related to the column: review.
	 * @param review the review value you wish to set
	 */
	public void setReview(final List<Review> review) {
		this.review = review;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Movie clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Movie copy = new Movie();

		copy.setDirector(this.getDirector());
		copy.setDuration(this.getDuration());
		copy.setId(this.getId());
		copy.setOriginalTitle(this.getOriginalTitle());
		copy.setReleaseDate(this.getReleaseDate());
		copy.getActor().addAll(this.getActor());
		copy.getDate().addAll(this.getDate());
		copy.getGenri().addAll(this.getGenri());
		copy.getReview().addAll(this.getReview());
		return copy;
	}


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("duration: " + this.getDuration() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("originalTitle: " + this.getOriginalTitle() + ", ");
		sb.append("releaseDate: " + this.getReleaseDate() + ", ");
		return sb.toString();		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((director == null) ? 0 : director.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((genri == null) ? 0 : genri.hashCode());
		result = prime * result
				+ ((hashCode == null) ? 0 : hashCode.hashCode());
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
		if (actor == null) {
			if (other.actor != null)
				return false;
		} else if (!actor.equals(other.actor))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
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
		if (genri == null) {
			if (other.genri != null)
				return false;
		} else if (!genri.equals(other.genri))
			return false;
		if (hashCode == null) {
			if (other.hashCode != null)
				return false;
		} else if (!hashCode.equals(other.hashCode))
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
