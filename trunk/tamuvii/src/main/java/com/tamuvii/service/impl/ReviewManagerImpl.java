package com.tamuvii.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.dao.ReviewDAO;
import com.tamuvii.model.Review;
import com.tamuvii.model.ReviewExample;
import com.tamuvii.model.ReviewExample.Criteria;
import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.service.ReviewManager;

public class ReviewManagerImpl implements ReviewManager {
	private ReviewDAO reviewDao = null;
	private CustomMovieDAO customMovieDao = null;
	
	public void setCustomMovieDao(CustomMovieDAO customMovieDao) {
		this.customMovieDao = customMovieDao;
	}

	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}



	public Review getReviewByMovie(Integer movie) {
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andMovieEqualTo(movie);		
		return (Review) reviewDao.selectByExample(reviewExample).get(0);
	}



	@SuppressWarnings("unchecked")
	public List<Review> getReviewsByMovie(Integer movie) {
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andMovieEqualTo(movie);		
		return reviewDao.selectByExample(reviewExample);
	}
	
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie) {
		return customMovieDao.getDetailedReviewsByMovie(movie);
	}



	@SuppressWarnings("unchecked")
	public Review getPersonalMovieReview(PersonalMovieFilterMap personalMovieFilterMap) {
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andMovieEqualTo(personalMovieFilterMap.getMovie());
		reviewCriteria.andUsernameEqualTo(personalMovieFilterMap.getUsername());
		List<Review> reviews = reviewDao.selectByExample(reviewExample);
		return (reviews.size() > 0) ? (Review) reviews.get(0) : new Review();
	}


	/*
	 * Controlla se il testo della review è nullo o vuoto, nel qual caso non effettua nessuna operazione.
	 * Altrimenti controlla se l'utente ha già inserito una review, nel qual caso fa l'update, altrimenti
	 * inserisce la review nuova settandogli l'ora di inserimento.
	 */
	@SuppressWarnings("unchecked")
	public void updatePersonalMovieReviewData(PersonalMovie personalMovie, String username) throws Exception {
		Review review = new Review();
		BeanUtils.copyProperties(review, personalMovie.getReview());
		if(review.getReviewtext() != null && !review.getReviewtext().trim().equals("")) {
			ReviewExample reviewExample = new ReviewExample();
			Criteria reviewCriteria = reviewExample.createCriteria();
			reviewCriteria.andUsernameEqualTo(username);
			reviewCriteria.andMovieEqualTo(personalMovie.getMovie());
			List<Review> reviews = reviewDao.selectByExample(reviewExample);
			Review tempReview = null;
			if(reviews.size() > 0) {
				tempReview  = (Review) reviewDao.selectByExample(reviewExample).get(0); 
				review.setReview(tempReview.getReview());
				review.setMovie(personalMovie.getMovie());
				review.setUsername(username);
				reviewDao.updateByExampleSelective(review, reviewExample);
			} else {
				review.setMovie(personalMovie.getMovie());
				review.setUsername(username);
				review.setDateinserted(Calendar.getInstance().getTime());
				reviewDao.insertSelective(review);
			}
		}
	}



	public Review getReviewById(Integer review) {
		return reviewDao.selectByPrimaryKey(review);
	}

	public void deleteReview(Integer movie, String username) {
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andMovieEqualTo(movie);
		reviewCriteria.andUsernameEqualTo(username);
		reviewDao.deleteByExample(reviewExample);
	}

	public void updateReviewById(Review r) {
		reviewDao.updateByPrimaryKey(r);	
	}

	public boolean isReviewOwner(String username, Integer review) {
		ReviewExample reviewExample = new ReviewExample();
		Criteria reviewCriteria = reviewExample.createCriteria();
		reviewCriteria.andUsernameEqualTo(username);
		reviewCriteria.andReviewEqualTo(review);
		return reviewDao.selectByExample(reviewExample) != null;
	}

}