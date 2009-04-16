package com.tamuvii.model;

import java.util.Date;

public class Opinion {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column opinion.opinion
	 * @ibatorgenerated
	 */
	private Integer opinion;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column opinion.review
	 * @ibatorgenerated
	 */
	private Integer review;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column opinion.user
	 * @ibatorgenerated
	 */
	private Integer user;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column opinion.opinion_text
	 * @ibatorgenerated
	 */
	private String opiniontext;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column opinion.date_inserted
	 * @ibatorgenerated
	 */
	private Date dateinserted;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column opinion.opinion
	 * @return  the value of opinion.opinion
	 * @ibatorgenerated
	 */
	public Integer getOpinion() {
		return opinion;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column opinion.opinion
	 * @param opinion  the value for opinion.opinion
	 * @ibatorgenerated
	 */
	public void setOpinion(Integer opinion) {
		this.opinion = opinion;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column opinion.review
	 * @return  the value of opinion.review
	 * @ibatorgenerated
	 */
	public Integer getReview() {
		return review;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column opinion.review
	 * @param review  the value for opinion.review
	 * @ibatorgenerated
	 */
	public void setReview(Integer review) {
		this.review = review;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column opinion.user
	 * @return  the value of opinion.user
	 * @ibatorgenerated
	 */
	public Integer getUser() {
		return user;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column opinion.user
	 * @param user  the value for opinion.user
	 * @ibatorgenerated
	 */
	public void setUser(Integer user) {
		this.user = user;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column opinion.opinion_text
	 * @return  the value of opinion.opinion_text
	 * @ibatorgenerated
	 */
	public String getOpiniontext() {
		return opiniontext;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column opinion.opinion_text
	 * @param opiniontext  the value for opinion.opinion_text
	 * @ibatorgenerated
	 */
	public void setOpiniontext(String opiniontext) {
		this.opiniontext = opiniontext == null ? null : opiniontext.trim();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column opinion.date_inserted
	 * @return  the value of opinion.date_inserted
	 * @ibatorgenerated
	 */
	public Date getDateinserted() {
		return dateinserted;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column opinion.date_inserted
	 * @param dateinserted  the value for opinion.date_inserted
	 * @ibatorgenerated
	 */
	public void setDateinserted(Date dateinserted) {
		this.dateinserted = dateinserted;
	}
}