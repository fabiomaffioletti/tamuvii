package com.tamuvii.model;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: localized_data.
 * @author autogenerated
 */

public interface ILocalizedData {



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
     * Return the value associated with the column: locale.
	 * @return A String object (this.locale)
	 */
	String getLocale();
	

  
    /**  
     * Set the value related to the column: locale.
	 * @param locale the locale value you wish to set
	 */
	void setLocale(final String locale);

    /**
     * Return the value associated with the column: localizedPlot.
	 * @return A String object (this.localizedPlot)
	 */
	String getLocalizedPlot();
	

  
    /**  
     * Set the value related to the column: localizedPlot.
	 * @param localizedPlot the localizedPlot value you wish to set
	 */
	void setLocalizedPlot(final String localizedPlot);

    /**
     * Return the value associated with the column: localizedTitle.
	 * @return A String object (this.localizedTitle)
	 */
	String getLocalizedTitle();
	

  
    /**  
     * Set the value related to the column: localizedTitle.
	 * @param localizedTitle the localizedTitle value you wish to set
	 */
	void setLocalizedTitle(final String localizedTitle);

    /**
     * Return the value associated with the column: movie.
	 * @return A Set&lt;Movie&gt; object (this.movie)
	 */
	Set<Movie> getMovie();
	
	/**
	 * Adds a bi-directional link of type Movie to the set.
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