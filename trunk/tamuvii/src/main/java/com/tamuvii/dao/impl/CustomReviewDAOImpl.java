package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomReviewDAO;
import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.queryfilter.SocialMovieFilter;

public class CustomReviewDAOImpl extends SqlMapClientDaoSupport implements CustomReviewDAO {
	
	public CustomReviewDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<DetailedReview> getDetailedReviewsByMovie(SocialMovieFilter smf) {
		return getSqlMapClientTemplate().queryForList("custom_review.getDetailedReviewsByMovie", smf);
	}

	public DetailedReview getDetailedReviewById(Integer review) {
		return (DetailedReview) getSqlMapClientTemplate().queryForObject("custom_review.getDetailedReviewById", review);
	}
	
}