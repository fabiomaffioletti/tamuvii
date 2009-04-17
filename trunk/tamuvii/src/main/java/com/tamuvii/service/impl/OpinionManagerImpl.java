package com.tamuvii.service.impl;

import java.util.List;

import com.tamuvii.dao.OpinionDAO;
import com.tamuvii.model.Opinion;
import com.tamuvii.model.OpinionExample;
import com.tamuvii.model.OpinionExample.Criteria;
import com.tamuvii.service.OpinionManager;

public class OpinionManagerImpl implements OpinionManager {
	private OpinionDAO opinionDao = null;

	public void setOpinionDao(OpinionDAO opinionDao) {
		this.opinionDao = opinionDao;
	}


	@SuppressWarnings("unchecked")
	public List<Opinion> getOpinionsByReview(Integer review) {
		OpinionExample opinionExample = new OpinionExample();
		Criteria opinionCriteria = opinionExample.createCriteria();
		opinionCriteria.andReviewEqualTo(review);
		return opinionDao.selectByExample(opinionExample);
	}

}