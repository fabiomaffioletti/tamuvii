package com.tamuvii.model;
import java.util.Set;


/** 
 * Object interface mapping for hibernate-handled table: opinion.
 * @author autogenerated
 */

public interface IOpinion {



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
     * Return the value associated with the column: opinionText.
	 * @return A String object (this.opinionText)
	 */
	String getOpinionText();
	

  
    /**  
     * Set the value related to the column: opinionText.
	 * @param opinionText the opinionText value you wish to set
	 */
	void setOpinionText(final String opinionText);

    /**
     * Return the value associated with the column: review.
	 * @return A Review object (this.review)
	 */
	Review getReview();
	

  
    /**  
     * Set the value related to the column: review.
	 * @param review the review value you wish to set
	 */
	void setReview(final Review review);

	// end of interface
}