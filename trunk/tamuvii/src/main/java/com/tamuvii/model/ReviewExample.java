package com.tamuvii.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewExample {

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table review
	 * @ibatorgenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database table review
	 * @ibatorgenerated
	 */
	protected List oredCriteria;

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	public ReviewExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	protected ReviewExample(ReviewExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
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
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table review
	 * @ibatorgenerated
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table review
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andReviewIsNull() {
			addCriterion("review is null");
			return this;
		}

		public Criteria andReviewIsNotNull() {
			addCriterion("review is not null");
			return this;
		}

		public Criteria andReviewEqualTo(Integer value) {
			addCriterion("review =", value, "review");
			return this;
		}

		public Criteria andReviewNotEqualTo(Integer value) {
			addCriterion("review <>", value, "review");
			return this;
		}

		public Criteria andReviewGreaterThan(Integer value) {
			addCriterion("review >", value, "review");
			return this;
		}

		public Criteria andReviewGreaterThanOrEqualTo(Integer value) {
			addCriterion("review >=", value, "review");
			return this;
		}

		public Criteria andReviewLessThan(Integer value) {
			addCriterion("review <", value, "review");
			return this;
		}

		public Criteria andReviewLessThanOrEqualTo(Integer value) {
			addCriterion("review <=", value, "review");
			return this;
		}

		public Criteria andReviewIn(List values) {
			addCriterion("review in", values, "review");
			return this;
		}

		public Criteria andReviewNotIn(List values) {
			addCriterion("review not in", values, "review");
			return this;
		}

		public Criteria andReviewBetween(Integer value1, Integer value2) {
			addCriterion("review between", value1, value2, "review");
			return this;
		}

		public Criteria andReviewNotBetween(Integer value1, Integer value2) {
			addCriterion("review not between", value1, value2, "review");
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

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return this;
		}

		public Criteria andTitleIn(List values) {
			addCriterion("title in", values, "title");
			return this;
		}

		public Criteria andTitleNotIn(List values) {
			addCriterion("title not in", values, "title");
			return this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return this;
		}

		public Criteria andReviewtextIsNull() {
			addCriterion("review_text is null");
			return this;
		}

		public Criteria andReviewtextIsNotNull() {
			addCriterion("review_text is not null");
			return this;
		}

		public Criteria andReviewtextEqualTo(String value) {
			addCriterion("review_text =", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextNotEqualTo(String value) {
			addCriterion("review_text <>", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextGreaterThan(String value) {
			addCriterion("review_text >", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextGreaterThanOrEqualTo(String value) {
			addCriterion("review_text >=", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextLessThan(String value) {
			addCriterion("review_text <", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextLessThanOrEqualTo(String value) {
			addCriterion("review_text <=", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextLike(String value) {
			addCriterion("review_text like", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextNotLike(String value) {
			addCriterion("review_text not like", value, "reviewtext");
			return this;
		}

		public Criteria andReviewtextIn(List values) {
			addCriterion("review_text in", values, "reviewtext");
			return this;
		}

		public Criteria andReviewtextNotIn(List values) {
			addCriterion("review_text not in", values, "reviewtext");
			return this;
		}

		public Criteria andReviewtextBetween(String value1, String value2) {
			addCriterion("review_text between", value1, value2, "reviewtext");
			return this;
		}

		public Criteria andReviewtextNotBetween(String value1, String value2) {
			addCriterion("review_text not between", value1, value2,
					"reviewtext");
			return this;
		}

		public Criteria andDateinsertedIsNull() {
			addCriterion("date_inserted is null");
			return this;
		}

		public Criteria andDateinsertedIsNotNull() {
			addCriterion("date_inserted is not null");
			return this;
		}

		public Criteria andDateinsertedEqualTo(Date value) {
			addCriterion("date_inserted =", value, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedNotEqualTo(Date value) {
			addCriterion("date_inserted <>", value, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedGreaterThan(Date value) {
			addCriterion("date_inserted >", value, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedGreaterThanOrEqualTo(Date value) {
			addCriterion("date_inserted >=", value, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedLessThan(Date value) {
			addCriterion("date_inserted <", value, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedLessThanOrEqualTo(Date value) {
			addCriterion("date_inserted <=", value, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedIn(List values) {
			addCriterion("date_inserted in", values, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedNotIn(List values) {
			addCriterion("date_inserted not in", values, "dateinserted");
			return this;
		}

		public Criteria andDateinsertedBetween(Date value1, Date value2) {
			addCriterion("date_inserted between", value1, value2,
					"dateinserted");
			return this;
		}

		public Criteria andDateinsertedNotBetween(Date value1, Date value2) {
			addCriterion("date_inserted not between", value1, value2,
					"dateinserted");
			return this;
		}
	}
}