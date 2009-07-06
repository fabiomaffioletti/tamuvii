package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.CustomOpinionDAO;
import com.tamuvii.dao.OpinionDAO;
import com.tamuvii.model.Opinion;
import com.tamuvii.model.OpinionExample;
import com.tamuvii.model.OpinionExample.Criteria;
import com.tamuvii.pojo.DetailedOpinion;
import com.tamuvii.service.OpinionManager;

public class OpinionManagerImpl implements OpinionManager {
	private OpinionDAO opinionDao = null;
	private CustomOpinionDAO customOpinionDao = null;

	public void setOpinionDao(OpinionDAO opinionDao) {
		this.opinionDao = opinionDao;
	}
	public void setCustomOpinionDao(CustomOpinionDAO customOpinionDao) {
		this.customOpinionDao = customOpinionDao;
	}


	@SuppressWarnings("unchecked")
	public List<Opinion> getOpinionsByReview(Integer review) {
		OpinionExample opinionExample = new OpinionExample();
		Criteria opinionCriteria = opinionExample.createCriteria();
		opinionCriteria.andReviewEqualTo(review);
		return opinionDao.selectByExample(opinionExample);
	}


	public void insertOpinion(Opinion opinion) {
		opinionDao.insertSelective(opinion);
	}


	public void deleteOpinion(Opinion opinion) {
		opinionDao.deleteByPrimaryKey(opinion.getOpinion());
	}


	@SuppressWarnings("unchecked")
	public Opinion doesOpinionBelongToUser(Integer opinionId, String username) {
		OpinionExample opinionExample = new OpinionExample();
		Criteria opinionCriteria = opinionExample.createCriteria();
		opinionCriteria.andOpinionEqualTo(opinionId);
		opinionCriteria.andUsernameEqualTo(username);
		List<Opinion> opinions = opinionDao.selectByExample(opinionExample);
		if(opinions.size() > 0)
			return opinions.get(0);
		else
			return null;
	}


	public List<DetailedOpinion> getDetailedOpinionsByReview(Integer review) {
		return customOpinionDao.getDetailedOpinionsByReview(review);
	}

}