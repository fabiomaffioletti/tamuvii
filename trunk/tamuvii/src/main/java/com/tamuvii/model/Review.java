package com.tamuvii.model;

import java.util.Date;

public class Review {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column review.review
	 * @ibatorgenerated
	 */
	private Integer review;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column review.username
	 * @ibatorgenerated
	 */
	private String username;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column review.movie
	 * @ibatorgenerated
	 */
	private Integer movie;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column review.title
	 * @ibatorgenerated
	 */
	private String title;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column review.review_text
	 * @ibatorgenerated
	 */
	private String reviewtext;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column review.date_inserted
	 * @ibatorgenerated
	 */
	private Date dateinserted;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column review.review
	 * @return  the value of review.review
	 * @ibatorgenerated
	 */
	public Integer getReview() {
		return review;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column review.review
	 * @param review  the value for review.review
	 * @ibatorgenerated
	 */
	public void setReview(Integer review) {
		this.review = review;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column review.username
	 * @return  the value of review.username
	 * @ibatorgenerated
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column review.username
	 * @param username  the value for review.username
	 * @ibatorgenerated
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column review.movie
	 * @return  the value of review.movie
	 * @ibatorgenerated
	 */
	public Integer getMovie() {
		return movie;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column review.movie
	 * @param movie  the value for review.movie
	 * @ibatorgenerated
	 */
	public void setMovie(Integer movie) {
		this.movie = movie;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column review.title
	 * @return  the value of review.title
	 * @ibatorgenerated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column review.title
	 * @param title  the value for review.title
	 * @ibatorgenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column review.review_text
	 * @return  the value of review.review_text
	 * @ibatorgenerated
	 */
	public String getReviewtext() {
		return reviewtext;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column review.review_text
	 * @param reviewtext  the value for review.review_text
	 * @ibatorgenerated
	 */
	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext == null ? null : reviewtext.trim();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column review.date_inserted
	 * @return  the value of review.date_inserted
	 * @ibatorgenerated
	 */
	public Date getDateinserted() {
		return dateinserted;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column review.date_inserted
	 * @param dateinserted  the value for review.date_inserted
	 * @ibatorgenerated
	 */
	public void setDateinserted(Date dateinserted) {
		this.dateinserted = dateinserted;
	}
}