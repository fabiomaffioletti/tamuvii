package com.tamuvii.model;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: director.
 * @author autogenerated
 */

public interface IDirector {



    /**
     * Return the value associated with the column: aka.
	 * @return A String object (this.aka)
	 */
	String getAka();
	

  
    /**  
     * Set the value related to the column: aka.
	 * @param aka the aka value you wish to set
	 */
	void setAka(final String aka);

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
	Integer getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final Integer id);

    /**
     * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	String getName();
	

  
    /**  
     * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	void setName(final String name);

    /**
     * Return the value associated with the column: surname.
	 * @return A String object (this.surname)
	 */
	String getSurname();
	

  
    /**  
     * Set the value related to the column: surname.
	 * @param surname the surname value you wish to set
	 */
	void setSurname(final String surname);

    /**
     * Return the value associated with the column: movie.
	 * @return A Set&lt;Movie&gt; object (this.movie)
	 */
	Set<Movie> getMovie();
	
	/**
	 * Adds a bi-directional link of type Movie to the movie set.
	 * @param movie item to add
	 */
	void addMovie(Movie movie);

  
    /**  
     * Set the value related to the column: movie.
	 * @param movie the movie value you wish to set
	 */
	void setMovie(final Set<Movie> movie);

	// end of interface
}