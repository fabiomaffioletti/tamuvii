package com.tamuvii.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tamuvii.dao.UserReviewVoteDAO;
import com.tamuvii.exception.UserReviewAlreadyVotedException;
import com.tamuvii.exception.UserReviewOwnVoteException;
import com.tamuvii.model.AppUser;
import com.tamuvii.model.Review;
import com.tamuvii.model.UserReviewVote;
import com.tamuvii.model.UserReviewVoteKey;
import com.tamuvii.service.AppUserManager;
import com.tamuvii.service.ConfigManager;
import com.tamuvii.service.MailEngine;
import com.tamuvii.service.ReviewManager;
import com.tamuvii.service.UserReviewVoteManager;
import com.tamuvii.util.TamuviiConstants;

public class UserReviewVoteManagerImpl implements UserReviewVoteManager {
	protected final Log log = LogFactory.getLog(getClass());
	
	private UserReviewVoteDAO userReviewVoteDao = null;
	private ReviewManager reviewManager = null;
	private AppUserManager appUserManager = null;
	private MailEngine mailEngine = null;
	private ConfigManager configManager = null;
	
	
	public void setAppUserManager(AppUserManager appUserManager) {
		this.appUserManager = appUserManager;
	}
	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}
	public void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}
	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}
	public void setUserReviewVoteDao(UserReviewVoteDAO userReviewVoteDao) {
		this.userReviewVoteDao = userReviewVoteDao;
	}


	public boolean canVote(String username, Integer review) {
		UserReviewVoteKey userReviewVoteKey = new UserReviewVoteKey();
		userReviewVoteKey.setUsername(username);
		userReviewVoteKey.setReview(review);
		return userReviewVoteDao.selectByPrimaryKey(userReviewVoteKey) == null;
	}
	
	
	public int voteOk(String username, Integer review) {
		if(canVote(username, review)) {
			if(!reviewManager.isReviewOwner(username, review)) {
				UserReviewVote userReviewVote = new UserReviewVote();
				userReviewVote.setUsername(username);
				userReviewVote.setReview(review);
				userReviewVote.setDatevoted(Calendar.getInstance().getTime());
				userReviewVoteDao.insert(userReviewVote);

				Review r = reviewManager.getReviewById(review);
				int ok = r.getOk();
				r.setOk(ok+1);
				reviewManager.updateReviewById(r);
				
				return ok+1;

			} else {
				return TamuviiConstants.ERROR_REVIEW_OWN_VOTE;
			}
		} else {
			return TamuviiConstants.ERROR_REVIEW_ALREADY_VOTED;
		}
	}
	

	public int voteKo(String username, Integer review) {
		if(canVote(username, review)) {
			if(!reviewManager.isReviewOwner(username, review)) {
				UserReviewVote userReviewVote = new UserReviewVote();
				userReviewVote.setUsername(username);
				userReviewVote.setReview(review);
				userReviewVote.setDatevoted(Calendar.getInstance().getTime());
				userReviewVoteDao.insert(userReviewVote);
				
				Review r = reviewManager.getReviewById(review);
				int ko = r.getKo();
				r.setKo(ko+1);
				reviewManager.updateReviewById(r);
				
				return ko+1;
				
			} else {
				return TamuviiConstants.ERROR_REVIEW_OWN_VOTE;
			}
			
		} else {
			return TamuviiConstants.ERROR_REVIEW_ALREADY_VOTED;
		}
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public int voteOkDWR(String username, Integer review) throws UserReviewOwnVoteException, UserReviewAlreadyVotedException {
		if(canVote(username, review)) {
			if(!reviewManager.isReviewOwner(username, review)) {
				UserReviewVote userReviewVote = new UserReviewVote();
				userReviewVote.setUsername(username);
				userReviewVote.setReview(review);
				userReviewVote.setDatevoted(Calendar.getInstance().getTime());
				userReviewVoteDao.insert(userReviewVote);

				Review r = reviewManager.getReviewById(review);
				int ok = r.getOk();
				r.setOk(ok+1);
				reviewManager.updateReviewById(r);
				
				Map model = new HashMap();
				model.put("r", r);
				AppUser user = appUserManager.getUserByUsername(r.getUsername());
				model.put("user", user);
				String templateName = "";
				String emailSubject = "";
				try {
					templateName = configManager.getString(TamuviiConstants.REVIEWVOTEDTEMPLATE + user.getCountry());
					emailSubject = configManager.getString(TamuviiConstants.REVIEWVOTEDSUBJECT + user.getCountry());
				} catch(NullPointerException npe) {
					templateName = configManager.getString(TamuviiConstants.REVIEWVOTEDTEMPLATE + "EN");
					emailSubject = configManager.getString(TamuviiConstants.REVIEWVOTEDSUBJECT + "EN");
				}
				mailEngine.sendHtmlMessage(null, new String[]{user.getEmail()}, emailSubject, templateName, model, true);
				
				return ok+1;

			} else {
				log.warn("User "+username +" is attempting to vote his own review ("+review+")");
				throw new UserReviewOwnVoteException();
			}
		} else {
			log.warn("User "+username +" is attempting to re-vote review ("+review+")");
			throw new UserReviewAlreadyVotedException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public int voteKoDWR(String username, Integer review) throws UserReviewOwnVoteException, UserReviewAlreadyVotedException {
		if(canVote(username, review)) {
			if(!reviewManager.isReviewOwner(username, review)) {
				UserReviewVote userReviewVote = new UserReviewVote();
				userReviewVote.setUsername(username);
				userReviewVote.setReview(review);
				userReviewVote.setDatevoted(Calendar.getInstance().getTime());
				userReviewVoteDao.insert(userReviewVote);
				
				Review r = reviewManager.getReviewById(review);
				int ko = r.getKo();
				r.setKo(ko+1);
				reviewManager.updateReviewById(r);
				
				Map model = new HashMap();
				model.put("r", r);
				AppUser user = appUserManager.getUserByUsername(r.getUsername());
				model.put("user", user);
				String templateName = "";
				String emailSubject = "";
				try {
					templateName = configManager.getString(TamuviiConstants.REVIEWVOTEDTEMPLATE + user.getCountry());
					emailSubject = configManager.getString(TamuviiConstants.REVIEWVOTEDSUBJECT + user.getCountry());
				} catch(NullPointerException npe) {
					templateName = configManager.getString(TamuviiConstants.REVIEWVOTEDTEMPLATE + "EN");
					emailSubject = configManager.getString(TamuviiConstants.REVIEWVOTEDSUBJECT + "EN");
				}
				mailEngine.sendHtmlMessage(null, new String[]{user.getEmail()}, emailSubject, templateName, model, true);
				
				return ko+1;
				
			} else {
				log.warn("User "+username +" is attempting to vote his own review ("+review+")");
				throw new UserReviewOwnVoteException();
			}
			
		} else {
			log.warn("User "+username +" is attempting to re-vote review ("+review+")");
			throw new UserReviewAlreadyVotedException();
		}
	}
}