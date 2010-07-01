package com.tamuvii.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.OpinionDAO;
import com.tamuvii.model.Opinion;

public class OpinionDAOImpl extends SqlMapClientDaoSupport implements OpinionDAO {

	@SuppressWarnings("unchecked")
	public List<Opinion> getOpinionsByReview(Map queryMap) {
		List<Opinion> opinions = getSqlMapClientTemplate().queryForList("opinion.getOpinionsByReview", queryMap);
		return opinions;
	}

	public void addOpinion(Opinion opinion) {
		getSqlMapClientTemplate().insert("opinion.addOpinion", opinion);
	}

	public void updateOpinion(Opinion opinion) {
		getSqlMapClientTemplate().update("opinion.updateOpinion", opinion);
	}

	public void deleteOpinion(Opinion opinion) {
		getSqlMapClientTemplate().delete("opinion.deleteOpinion", opinion);		
	}

	public Opinion isOpinionWrittenByUser(Map queryMap) {
		return (Opinion) getSqlMapClientTemplate().queryForObject("opinion.isOpinionWrittenByUser", queryMap);
	}

	public Opinion getOpinionById(Long id) {
		return (Opinion) getSqlMapClientTemplate().queryForObject("opinion.getOpinionById", id);
	}


}