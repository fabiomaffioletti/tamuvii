package com.tamuvii.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserToMovieExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public UserToMovieExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    protected UserToMovieExample(UserToMovieExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table user_to_movie
     *
     * @ibatorgenerated
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andMovieIsNull() {
            addCriterion("movie is null");
            return this;
        }

        public Criteria andMovieIsNotNull() {
            addCriterion("movie is not null");
            return this;
        }

        public Criteria andMovieEqualTo(Integer value) {
            addCriterion("movie =", value, "movie");
            return this;
        }

        public Criteria andMovieNotEqualTo(Integer value) {
            addCriterion("movie <>", value, "movie");
            return this;
        }

        public Criteria andMovieGreaterThan(Integer value) {
            addCriterion("movie >", value, "movie");
            return this;
        }

        public Criteria andMovieGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie >=", value, "movie");
            return this;
        }

        public Criteria andMovieLessThan(Integer value) {
            addCriterion("movie <", value, "movie");
            return this;
        }

        public Criteria andMovieLessThanOrEqualTo(Integer value) {
            addCriterion("movie <=", value, "movie");
            return this;
        }

        public Criteria andMovieIn(List values) {
            addCriterion("movie in", values, "movie");
            return this;
        }

        public Criteria andMovieNotIn(List values) {
            addCriterion("movie not in", values, "movie");
            return this;
        }

        public Criteria andMovieBetween(Integer value1, Integer value2) {
            addCriterion("movie between", value1, value2, "movie");
            return this;
        }

        public Criteria andMovieNotBetween(Integer value1, Integer value2) {
            addCriterion("movie not between", value1, value2, "movie");
            return this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return this;
        }

        public Criteria andUsernameIn(List values) {
            addCriterion("username in", values, "username");
            return this;
        }

        public Criteria andUsernameNotIn(List values) {
            addCriterion("username not in", values, "username");
            return this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return this;
        }

        public Criteria andDateaddedIsNull() {
            addCriterion("date_added is null");
            return this;
        }

        public Criteria andDateaddedIsNotNull() {
            addCriterion("date_added is not null");
            return this;
        }

        public Criteria andDateaddedEqualTo(Date value) {
            addCriterion("date_added =", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedNotEqualTo(Date value) {
            addCriterion("date_added <>", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedGreaterThan(Date value) {
            addCriterion("date_added >", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_added >=", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedLessThan(Date value) {
            addCriterion("date_added <", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedLessThanOrEqualTo(Date value) {
            addCriterion("date_added <=", value, "dateadded");
            return this;
        }

        public Criteria andDateaddedIn(List values) {
            addCriterion("date_added in", values, "dateadded");
            return this;
        }

        public Criteria andDateaddedNotIn(List values) {
            addCriterion("date_added not in", values, "dateadded");
            return this;
        }

        public Criteria andDateaddedBetween(Date value1, Date value2) {
            addCriterion("date_added between", value1, value2, "dateadded");
            return this;
        }

        public Criteria andDateaddedNotBetween(Date value1, Date value2) {
            addCriterion("date_added not between", value1, value2, "dateadded");
            return this;
        }

        public Criteria andDateviewedIsNull() {
            addCriterion("date_viewed is null");
            return this;
        }

        public Criteria andDateviewedIsNotNull() {
            addCriterion("date_viewed is not null");
            return this;
        }

        public Criteria andDateviewedEqualTo(Date value) {
            addCriterion("date_viewed =", value, "dateviewed");
            return this;
        }

        public Criteria andDateviewedNotEqualTo(Date value) {
            addCriterion("date_viewed <>", value, "dateviewed");
            return this;
        }

        public Criteria andDateviewedGreaterThan(Date value) {
            addCriterion("date_viewed >", value, "dateviewed");
            return this;
        }

        public Criteria andDateviewedGreaterThanOrEqualTo(Date value) {
            addCriterion("date_viewed >=", value, "dateviewed");
            return this;
        }

        public Criteria andDateviewedLessThan(Date value) {
            addCriterion("date_viewed <", value, "dateviewed");
            return this;
        }

        public Criteria andDateviewedLessThanOrEqualTo(Date value) {
            addCriterion("date_viewed <=", value, "dateviewed");
            return this;
        }

        public Criteria andDateviewedIn(List values) {
            addCriterion("date_viewed in", values, "dateviewed");
            return this;
        }

        public Criteria andDateviewedNotIn(List values) {
            addCriterion("date_viewed not in", values, "dateviewed");
            return this;
        }

        public Criteria andDateviewedBetween(Date value1, Date value2) {
            addCriterion("date_viewed between", value1, value2, "dateviewed");
            return this;
        }

        public Criteria andDateviewedNotBetween(Date value1, Date value2) {
            addCriterion("date_viewed not between", value1, value2, "dateviewed");
            return this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return this;
        }

        public Criteria andMarkEqualTo(Integer value) {
            addCriterion("mark =", value, "mark");
            return this;
        }

        public Criteria andMarkNotEqualTo(Integer value) {
            addCriterion("mark <>", value, "mark");
            return this;
        }

        public Criteria andMarkGreaterThan(Integer value) {
            addCriterion("mark >", value, "mark");
            return this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark >=", value, "mark");
            return this;
        }

        public Criteria andMarkLessThan(Integer value) {
            addCriterion("mark <", value, "mark");
            return this;
        }

        public Criteria andMarkLessThanOrEqualTo(Integer value) {
            addCriterion("mark <=", value, "mark");
            return this;
        }

        public Criteria andMarkIn(List values) {
            addCriterion("mark in", values, "mark");
            return this;
        }

        public Criteria andMarkNotIn(List values) {
            addCriterion("mark not in", values, "mark");
            return this;
        }

        public Criteria andMarkBetween(Integer value1, Integer value2) {
            addCriterion("mark between", value1, value2, "mark");
            return this;
        }

        public Criteria andMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return this;
        }
    }
}