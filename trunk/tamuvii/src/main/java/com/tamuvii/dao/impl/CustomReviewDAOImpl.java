package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomReviewDAO;
import com.tamuvii.pojo.DetailedReview;

public class CustomReviewDAOImpl extends SqlMapClientDaoSupport implements CustomReviewDAO {
	
	public CustomReviewDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie) {
		return getSqlMapClientTemplate().queryForList("custom_review.getDetailedReviewsByMovie", movie);
	}
	
}