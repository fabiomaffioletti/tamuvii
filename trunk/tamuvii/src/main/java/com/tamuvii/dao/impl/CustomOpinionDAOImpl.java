package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomOpinionDAO;
import com.tamuvii.pojo.DetailedOpinion;

public class CustomOpinionDAOImpl extends SqlMapClientDaoSupport implements CustomOpinionDAO {
	
	public CustomOpinionDAOImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<DetailedOpinion> getDetailedOpinionsByReview(Integer review) {
		return getSqlMapClientTemplate().queryForList("custom_opinion.getDetailedOpinionsByReview", review);
	}

}