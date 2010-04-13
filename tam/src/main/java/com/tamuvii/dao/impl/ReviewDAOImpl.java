package com.tamuvii.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.model.Opinion;
import com.tamuvii.model.Review;
import com.tamuvii.pojo.OpinionItem;
import com.tamuvii.pojo.ReviewItem;

public class ReviewDAOImpl extends SqlMapClientDaoSupport implements ReviewDAO {

	@SuppressWarnings("unchecked")
	public Review getReviewByMovieAndUsername(Map queryMap) {
		return (Review) getSqlMapClientTemplate().queryForObject("review.getReviewByMovieAndUsername", queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<Review> getReviewsByMovie(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("review.getReviewsByMovie", queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<Review> getReviewsByUsername(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("review.getReviewsByUsername", queryMap);
	}

	public void addReview(Review review) {
		getSqlMapClientTemplate().insert("review.addReview", review);
	}

	public void updateReview(Review review) {
		getSqlMapClientTemplate().update("review.updateReview", review);
	}

	@SuppressWarnings("unchecked")
	public void deleteReview(Map queryMap) {
		getSqlMapClientTemplate().delete("review.deleteReview", queryMap);		
	}

	@SuppressWarnings("unchecked")
	public Review isReviewWrittenByUser(Map queryMap) {
		return (Review) getSqlMapClientTemplate().queryForObject("review.isReviewWrittenByUser", queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public Integer isReviewVotedByUser(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("review.isReviewVotedByUser", queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public void addReviewVote(Map queryMap) {
		getSqlMapClientTemplate().insert("review.addReviewVote", queryMap);
	}

	public Integer getReviewsCountByUsername(String username) {
		return (Integer) getSqlMapClientTemplate().queryForObject("review.getReviewsCountByUsername", username);
	}

	@SuppressWarnings("unchecked")
	public void addNegative(Map queryMap) {
		getSqlMapClientTemplate().update("review.addNegative", queryMap);
	}

	@SuppressWarnings("unchecked")
	public void addPositive(Map queryMap) {
		getSqlMapClientTemplate().update("review.addPositive", queryMap);
	}

	@SuppressWarnings("unchecked")
	public ReviewItem getReviewItemByMovieAndUsername(Map queryMap) {
		return (ReviewItem) getSqlMapClientTemplate().queryForObject("review.getReviewItemByMovieAndUsername", queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<OpinionItem> getReviewOpinions(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("review.getReviewOpinions", queryMap);
	}

	public void addOpinion(Opinion opinion) {
		getSqlMapClientTemplate().insert("review.addOpinion", opinion);
	}

}