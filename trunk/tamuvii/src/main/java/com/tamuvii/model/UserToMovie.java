package com.tamuvii.model;

import java.util.Date;

public class UserToMovie extends UserToMovieKey {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user_to_movie.date_added
     *
     * @ibatorgenerated
     */
    private Date dateadded;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user_to_movie.date_viewed
     *
     * @ibatorgenerated
     */
    private Date dateviewed;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user_to_movie.mark
     *
     * @ibatorgenerated
     */
    private Integer mark;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user_to_movie.date_added
     *
     * @return the value of user_to_movie.date_added
     *
     * @ibatorgenerated
     */
    public Date getDateadded() {
        return dateadded;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user_to_movie.date_added
     *
     * @param dateadded the value for user_to_movie.date_added
     *
     * @ibatorgenerated
     */
    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user_to_movie.date_viewed
     *
     * @return the value of user_to_movie.date_viewed
     *
     * @ibatorgenerated
     */
    public Date getDateviewed() {
        return dateviewed;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user_to_movie.date_viewed
     *
     * @param dateviewed the value for user_to_movie.date_viewed
     *
     * @ibatorgenerated
     */
    public void setDateviewed(Date dateviewed) {
        this.dateviewed = dateviewed;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user_to_movie.mark
     *
     * @return the value of user_to_movie.mark
     *
     * @ibatorgenerated
     */
    public Integer getMark() {
        return mark;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user_to_movie.mark
     *
     * @param mark the value for user_to_movie.mark
     *
     * @ibatorgenerated
     */
    public void setMark(Integer mark) {
        this.mark = mark;
    }
}