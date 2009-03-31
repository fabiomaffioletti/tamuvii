package com.tamuvii.model;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: review.
 * @author autogenerated
 */

public interface IReview {



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
     * Return the value associated with the column: reviewText.
	 * @return A String object (this.reviewText)
	 */
	String getReviewText();
	

  
    /**  
     * Set the value related to the column: reviewText.
	 * @param reviewText the reviewText value you wish to set
	 */
	void setReviewText(final String reviewText);

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

    /**
     * Return the value associated with the column: opinion.
	 * @return A Set&lt;Opinion&gt; object (this.opinion)
	 */
	Set<Opinion> getOpinion();
	
	/**
	 * Adds a bi-directional link of type Opinion to the opinion set.
	 * @param opinion item to add
	 */
	void addOpinion(Opinion opinion);

  
    /**  
     * Set the value related to the column: opinion.
	 * @param opinion the opinion value you wish to set
	 */
	void setOpinion(final Set<Opinion> opinion);

    /**
     * Return the value associated with the column: title.
	 * @return A String object (this.title)
	 */
	String getTitle();
	

  
    /**  
     * Set the value related to the column: title.
	 * @param title the title value you wish to set
	 */
	void setTitle(final String title);

    /**
     * Return the value associated with the column: user.
	 * @return A Integer object (this.user)
	 */
	Integer getUser();
	

  
    /**  
     * Set the value related to the column: user.
	 * @param user the user value you wish to set
	 */
	void setUser(final Integer user);

	// end of interface
}