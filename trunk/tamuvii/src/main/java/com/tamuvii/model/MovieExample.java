package com.tamuvii.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    public MovieExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    protected MovieExample(MovieExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
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
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table movie
     *
     * @ibatorgenerated
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table movie
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

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return this;
        }

        public Criteria andDurationIn(List values) {
            addCriterion("duration in", values, "duration");
            return this;
        }

        public Criteria andDurationNotIn(List values) {
            addCriterion("duration not in", values, "duration");
            return this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return this;
        }

        public Criteria andOriginaltitleIsNull() {
            addCriterion("original_title is null");
            return this;
        }

        public Criteria andOriginaltitleIsNotNull() {
            addCriterion("original_title is not null");
            return this;
        }

        public Criteria andOriginaltitleEqualTo(String value) {
            addCriterion("original_title =", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleNotEqualTo(String value) {
            addCriterion("original_title <>", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleGreaterThan(String value) {
            addCriterion("original_title >", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleGreaterThanOrEqualTo(String value) {
            addCriterion("original_title >=", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleLessThan(String value) {
            addCriterion("original_title <", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleLessThanOrEqualTo(String value) {
            addCriterion("original_title <=", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleLike(String value) {
            addCriterion("original_title like", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleNotLike(String value) {
            addCriterion("original_title not like", value, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleIn(List values) {
            addCriterion("original_title in", values, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleNotIn(List values) {
            addCriterion("original_title not in", values, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleBetween(String value1, String value2) {
            addCriterion("original_title between", value1, value2, "originaltitle");
            return this;
        }

        public Criteria andOriginaltitleNotBetween(String value1, String value2) {
            addCriterion("original_title not between", value1, value2, "originaltitle");
            return this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return this;
        }

        public Criteria andDirectorEqualTo(Integer value) {
            addCriterion("director =", value, "director");
            return this;
        }

        public Criteria andDirectorNotEqualTo(Integer value) {
            addCriterion("director <>", value, "director");
            return this;
        }

        public Criteria andDirectorGreaterThan(Integer value) {
            addCriterion("director >", value, "director");
            return this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(Integer value) {
            addCriterion("director >=", value, "director");
            return this;
        }

        public Criteria andDirectorLessThan(Integer value) {
            addCriterion("director <", value, "director");
            return this;
        }

        public Criteria andDirectorLessThanOrEqualTo(Integer value) {
            addCriterion("director <=", value, "director");
            return this;
        }

        public Criteria andDirectorIn(List values) {
            addCriterion("director in", values, "director");
            return this;
        }

        public Criteria andDirectorNotIn(List values) {
            addCriterion("director not in", values, "director");
            return this;
        }

        public Criteria andDirectorBetween(Integer value1, Integer value2) {
            addCriterion("director between", value1, value2, "director");
            return this;
        }

        public Criteria andDirectorNotBetween(Integer value1, Integer value2) {
            addCriterion("director not between", value1, value2, "director");
            return this;
        }

        public Criteria andReleasedateIsNull() {
            addCriterion("release_date is null");
            return this;
        }

        public Criteria andReleasedateIsNotNull() {
            addCriterion("release_date is not null");
            return this;
        }

        public Criteria andReleasedateEqualTo(Date value) {
            addCriterion("release_date =", value, "releasedate");
            return this;
        }

        public Criteria andReleasedateNotEqualTo(Date value) {
            addCriterion("release_date <>", value, "releasedate");
            return this;
        }

        public Criteria andReleasedateGreaterThan(Date value) {
            addCriterion("release_date >", value, "releasedate");
            return this;
        }

        public Criteria andReleasedateGreaterThanOrEqualTo(Date value) {
            addCriterion("release_date >=", value, "releasedate");
            return this;
        }

        public Criteria andReleasedateLessThan(Date value) {
            addCriterion("release_date <", value, "releasedate");
            return this;
        }

        public Criteria andReleasedateLessThanOrEqualTo(Date value) {
            addCriterion("release_date <=", value, "releasedate");
            return this;
        }

        public Criteria andReleasedateIn(List values) {
            addCriterion("release_date in", values, "releasedate");
            return this;
        }

        public Criteria andReleasedateNotIn(List values) {
            addCriterion("release_date not in", values, "releasedate");
            return this;
        }

        public Criteria andReleasedateBetween(Date value1, Date value2) {
            addCriterion("release_date between", value1, value2, "releasedate");
            return this;
        }

        public Criteria andReleasedateNotBetween(Date value1, Date value2) {
            addCriterion("release_date not between", value1, value2, "releasedate");
            return this;
        }
    }
}