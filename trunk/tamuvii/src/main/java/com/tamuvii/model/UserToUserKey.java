package com.tamuvii.model;

public class UserToUserKey {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user_to_user.first
     *
     * @ibatorgenerated
     */
    private String first;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column user_to_user.second
     *
     * @ibatorgenerated
     */
    private String second;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user_to_user.first
     *
     * @return the value of user_to_user.first
     *
     * @ibatorgenerated
     */
    public String getFirst() {
        return first;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user_to_user.first
     *
     * @param first the value for user_to_user.first
     *
     * @ibatorgenerated
     */
    public void setFirst(String first) {
        this.first = first == null ? null : first.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column user_to_user.second
     *
     * @return the value of user_to_user.second
     *
     * @ibatorgenerated
     */
    public String getSecond() {
        return second;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column user_to_user.second
     *
     * @param second the value for user_to_user.second
     *
     * @ibatorgenerated
     */
    public void setSecond(String second) {
        this.second = second == null ? null : second.trim();
    }
}