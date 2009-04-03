package com.tamuvii.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/** 
 * Object mapping for hibernate-handled table: opinion.
 * @author autogenerated
 */

@Entity
@Table(name = "opinion", catalog = "tamuvii")
public class Opinion implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -559009204L;
	
	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private Integer id;
	/** Field mapping. */
	private String opinionText;
	/** Field mapping. */
	private Review review;

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Opinion() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Opinion(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id Integer object;
	 * @param opinionText String object;
	 * @param review Review object;
	 */
	public Opinion(Integer id, String opinionText, Review review) {

		this.id = id;
		this.opinionText = opinionText;
		this.review = review;
	}
	
 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Opinion.class;
	}
 

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@Column( name = "opinion"  )
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
     * Return the value associated with the column: opinionText.
	 * @return A String object (this.opinionText)
	 */
	@Column( name = "opinion_text" )
	public String getOpinionText() {
		return this.opinionText;
		
	}
	

  
    /**  
     * Set the value related to the column: opinionText.
	 * @param opinionText the opinionText value you wish to set
	 */
	public void setOpinionText(final String opinionText) {
		this.opinionText = opinionText;
	}

    /**
     * Return the value associated with the column: review.
	 * @return A Review object (this.review)
	 */
	@ManyToOne
	@JoinColumn(name = "review" )
	public Review getReview() {
		return this.review;
		
	}
	

  
    /**  
     * Set the value related to the column: review.
	 * @param review the review value you wish to set
	 */
	public void setReview(final Review review) {
		this.review = review;
	}



   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Opinion clone() throws CloneNotSupportedException {
		super.clone();  // keep hierarchy
        final Opinion copy = new Opinion();

		copy.setId(this.getId());
		copy.setOpinionText(this.getOpinionText());
		copy.setReview(this.getReview());
		return copy;
	}


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("opinionText: " + this.getOpinionText() + ", ");
		return sb.toString();		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hashCode == null) ? 0 : hashCode.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((opinionText == null) ? 0 : opinionText.hashCode());
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
		Opinion other = (Opinion) obj;
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
		if (opinionText == null) {
			if (other.opinionText != null)
				return false;
		} else if (!opinionText.equals(other.opinionText))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		return true;
	}


}