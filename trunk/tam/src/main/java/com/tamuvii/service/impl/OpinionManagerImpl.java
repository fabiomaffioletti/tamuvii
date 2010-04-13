package com.tamuvii.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.dao.OpinionDAO;
import com.tamuvii.dao.UserDAO;
import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.Opinion;
import com.tamuvii.service.OpinionManager;
import com.tamuvii.util.RequestUtils;

public class OpinionManagerImpl implements OpinionManager {
	private OpinionDAO opinionDao = null;
	private UserDAO userDao = null;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void setOpinionDao(OpinionDAO opinionDao) {
		this.opinionDao = opinionDao;
	}
	
	

	public void addOpinion(Opinion opinion) {
		opinionDao.addOpinion(opinion);
	}
	public void addOpinion(Long reviewer, Long movie, String text) {
		Opinion opinion = new Opinion();
		opinion.setUser(userDao.getUserByUsername(RequestUtils.getRequestUsername(null)).getId());
		opinion.setReviewer(reviewer);
		opinion.setMovie(movie);
		opinion.setDateAdded(new Date());
		addOpinion(opinion);
	}

	public void deleteOpinion(Long id) throws IllegalOperationException {
		Opinion opinion = opinionDao.getOpinionById(id);
		if(isOpinionWrittenByUser(opinion.getReviewer(), opinion.getMovie()) != null) {
			opinionDao.deleteOpinion(opinion);
		} else {
			throw new IllegalOperationException("User "+ RequestUtils.getRequestUsername(null) + " is trying to delete an unowned opinion with id: "+opinion.getId());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Opinion> getOpinionsByReview(String reviewer, Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("reviewer", reviewer);
		queryMap.put("movie", movie);
		return opinionDao.getOpinionsByReview(queryMap);
	}

	@SuppressWarnings("unchecked")
	public Opinion isOpinionWrittenByUser(Long reviewer, Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(null));
		queryMap.put("reviewer", reviewer);
		queryMap.put("movie", movie);
		return opinionDao.isOpinionWrittenByUser(queryMap);
	}

	public void updateOpinion(Opinion opinion) {
		opinionDao.updateOpinion(opinion);
	}
	
}