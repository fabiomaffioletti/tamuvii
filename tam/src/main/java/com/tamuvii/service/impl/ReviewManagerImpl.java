package com.tamuvii.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.dao.MovieDAO;
import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.dao.UserDAO;
import com.tamuvii.exception.IllegalOperationException;
import com.tamuvii.model.Opinion;
import com.tamuvii.model.Review;
import com.tamuvii.model.User;
import com.tamuvii.observer.events.EventType;
import com.tamuvii.observer.events.TamuviiEvent;
import com.tamuvii.observer.events.TamuviiEventImpl;
import com.tamuvii.observer.subject.TamuviiSubject;
import com.tamuvii.pojo.OpinionItem;
import com.tamuvii.pojo.ReviewItem;
import com.tamuvii.service.ReviewManager;
import com.tamuvii.util.RequestUtils;

public class ReviewManagerImpl extends ApplicationManager implements ReviewManager {
	private ReviewDAO reviewDao = null;
	private UserDAO userDao = null;
	private MovieDAO movieDao = null;
	private TamuviiSubject tamuviiEventDispatcher = null;

	public void setMovieDao(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}
	public void setTamuviiEventDispatcher(TamuviiSubject tamuviiEventDispatcher) {
		this.tamuviiEventDispatcher = tamuviiEventDispatcher;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}

	
	public void addReview(Review review) {
		reviewDao.addReview(review);
	}
	public void addReview(Long movie, String title, String text, Date dateAdded) {
		Review review = new Review();
		review.setUser(userDao.getUserByUsername(RequestUtils.getRequestUsername(null)).getId());
		review.setMovie(movie);
		review.setDateAdded(new Date());
		review.setText(text);
		review.setTitle(title);
		addReview(review);
	}

	@SuppressWarnings("unchecked")
	public void deleteReview(Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(null));
		queryMap.put("movie", movie);
		reviewDao.deleteReview(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public Review isReviewWrittenByUser(Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", RequestUtils.getRequestUsername(null));
		return reviewDao.isReviewWrittenByUser(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public Integer isReviewVotedByUser(String voter, Long movie, String reviewer) {
		Map queryMap = new HashMap();
		queryMap.put("voter", voter);
		queryMap.put("movie", movie);
		queryMap.put("username", reviewer);
		return reviewDao.isReviewVotedByUser(queryMap);
	}
	

	@SuppressWarnings("unchecked")
	public Review getReviewByMovieAndUsername(Long movie, String username) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("movie", movie);
		return reviewDao.getReviewByMovieAndUsername(queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<Review> getReviewsByMovie(Long movie, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return reviewDao.getReviewsByMovie(queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<Review> getReviewsByUsername(String username, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("username", username);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return reviewDao.getReviewsByUsername(queryMap);
	}

	public void updateReview(Review review) {
		reviewDao.updateReview(review);
	}

	public Integer getReviewsCountByUsername(String username) {
		return reviewDao.getReviewsCountByUsername(username);
	}

	
	/* VOTES */
	@SuppressWarnings("unchecked")
	public void addNegative(Long movie, String username) throws IllegalOperationException {
		if(isReviewVotedByUser(RequestUtils.getRequestUsername(null), movie, username) > 0) {
			log.warn("User "+ RequestUtils.getRequestUsername(null) + " trying to re-vote a review with movie: " + movie + " and username: " + username);
			throw new IllegalOperationException("Hai già votato per questa recensione");
			
		} else {
			if(!RequestUtils.getRequestUsername(username).equals(RequestUtils.getRequestUsername(null))) {
				Map queryMap = new HashMap();
				queryMap.put("movie", movie);
				queryMap.put("username", username);
				reviewDao.addNegative(queryMap);
				
				queryMap.put("voter", RequestUtils.getRequestUsername(null));
				queryMap.put("dateVoted", new Date());
				queryMap.put("positive", 0);
				reviewDao.addReviewVote(queryMap);
				
				TamuviiEvent reviewVotedEvent = new TamuviiEventImpl(EventType.REVIEW_VOTED, this);
				reviewVotedEvent.setEventProperty("type", "negative");
				reviewVotedEvent.setEventProperty("user", userDao.getUserByUsername(username));
				reviewVotedEvent.setEventProperty("movie", movieDao.getMovieItem(movie));
				reviewVotedEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				try {
					tamuviiEventDispatcher.notifyListeners(reviewVotedEvent);
				} catch (Exception e) {
					log.error("Error while notifying listeners to event: REVIEW_VOTED: ", e);
				}
				
			} else {
				log.warn("User "+username+" is trying to add a negative vote to one of his reviews with movie id: "+movie);
				throw new IllegalOperationException("Non è possibile votare una propria recensione");
			}
		}
	}
	@SuppressWarnings("unchecked")
	public void addPositive(Long movie, String username) throws IllegalOperationException {
		if(isReviewVotedByUser(RequestUtils.getRequestUsername(null), movie, username) > 0) {
			log.warn("User "+ RequestUtils.getRequestUsername(null) + " trying to re-vote a review with movie: " + movie + " and username: " + username);
			throw new IllegalOperationException("Hai già votato per questa recensione");
			
		} else {
			if(!RequestUtils.getRequestUsername(username).equals(RequestUtils.getRequestUsername(null))) {
				Map queryMap = new HashMap();
				queryMap.put("movie", movie);
				queryMap.put("username", username);
				reviewDao.addPositive(queryMap);
				
				queryMap.put("voter", RequestUtils.getRequestUsername(null));
				queryMap.put("dateVoted", new Date());
				queryMap.put("positive", 1);
				reviewDao.addReviewVote(queryMap);
	
				TamuviiEvent reviewVotedEvent = new TamuviiEventImpl(EventType.REVIEW_VOTED, this);
				reviewVotedEvent.setEventProperty("type", "positive");
				reviewVotedEvent.setEventProperty("user", userDao.getUserByUsername(username));
				reviewVotedEvent.setEventProperty("movie", movieDao.getMovieItem(movie));
				reviewVotedEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				try {
					tamuviiEventDispatcher.notifyListeners(reviewVotedEvent);
				} catch (Exception e) {
					log.error("Error while notifying listeners to event: REVIEW_VOTED: ", e);
				}
				
			} else {
				log.warn("User "+username+" is trying to add a positive vote to one of his reviews with movie id: "+movie);
				throw new IllegalOperationException("Non è possibile votare una propria recensione");
			}
		}
	}

	@SuppressWarnings("unchecked")
	public ReviewItem getReviewItemByMovieAndUsername(Long movie, String username) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", username);
		return reviewDao.getReviewItemByMovieAndUsername(queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<OpinionItem> getReviewOpinions(Long movie, String username) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", username);
		return reviewDao.getReviewOpinions(queryMap);
	}

	public void addOpinion(Long movie, Long user, String text) {
		Opinion opinion = new Opinion();
		opinion.setMovie(movie);
		opinion.setReviewer(user);
		opinion.setText(text);
		User writer = userDao.getUserByUsername(RequestUtils.getRequestUsername(null));
		opinion.setUser(writer.getId());
		opinion.setDateAdded(new Date());
		reviewDao.addOpinion(opinion);
		
		if(!writer.getId().equals(user)) {
			TamuviiEvent opinionWroteEvent = new TamuviiEventImpl(EventType.OPINION_WROTE, this);
			opinionWroteEvent.setEventProperty("movie", movieDao.getMovieItem(movie));
			opinionWroteEvent.setEventProperty("writer", writer);
			opinionWroteEvent.setEventProperty("user", userDao.getUserById(user));
			opinionWroteEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
			try {
				tamuviiEventDispatcher.notifyListeners(opinionWroteEvent);
			} catch (Exception e) {
				log.error("Error while notifying listeners to event: OPINION_WROTE: ", e);
			}
		}
		
	}

}