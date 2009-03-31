package com.tamuvii.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.proxy.HibernateProxy;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;


/** 
 * Object mapping for hibernate-handled table: genre.
 * @author autogenerated
 */

@Entity
@Table(name = "genre", catalog = "tamuvii")
public class Genre implements Cloneable, Serializable, IGenre {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559009208L;
	
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private Integer id = 0; // init for hibernate bug workaround
	/** Field mapping. */
	private Set<Movie> movie = new HashSet<Movie>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Genre() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Genre(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param description String object;
	 * @param id Integer object;
	 */
	public Genre(String description, Integer id) {

		this.description = description;
		this.id = id;
	}
	
 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Genre.class;
	}
 

    /**
     * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Length(max=200)
	@Column( length = 200  )
	public String getDescription() {
		return this.description;
		
	}
	

  
    /**  
     * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "genre"  )
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
     * Return the value associated with the column: movie.
	 * @return A Set&lt;Movie&gt; object (this.movie)
	 */
	@ManyToMany( fetch = FetchType.LAZY, mappedBy = "genri" )
	public Set<Movie> getMovie() {
		return this.movie;
		
	}
	
	/**
	 * Adds a bi-directional link of type Movie to the set.
	 * 
	 * @param movie item to add
	 */
	public void addMovie(Movie movie) {
		movie.getGenri().add(this);
		this.movie.add(movie);
	}

  
    /**  
     * Set the value related to the column: movie.
	 * @param movie the movie value you wish to set
	 */
	public void setMovie(final Set<Movie> movie) {
		this.movie = movie;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Genre clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Genre copy = new Genre();

		copy.setDescription(this.getDescription());
		copy.setId(this.getId());
		copy.getMovie().addAll(this.getMovie());
		return copy;
	}


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("id: " + this.getId() + ", ");
		return sb.toString();		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((hashCode == null) ? 0 : hashCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
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
		Genre other = (Genre) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		return true;
	}


	
}