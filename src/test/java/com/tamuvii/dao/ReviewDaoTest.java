package com.tamuvii.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.model.Review;
import com.tamuvii.pojo.OpinionItem;

public class ReviewDaoTest extends ApplicationTest {
	private ReviewDAO reviewDao = null;

	public void setReviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}

	
	@SuppressWarnings("unchecked")
	public void testGetReviewsByMovie() {
		Map queryMap = new HashMap();
		queryMap.put("movie", 1L);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<Review> rs = reviewDao.getReviewsByMovie(queryMap);
		assertNotNull(rs);
		assertTrue(rs.size() == 2);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetReviewsByUsername() {
		Map queryMap = new HashMap();
		queryMap.put("username", "fubbyo");
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		List<Review> rs = reviewDao.getReviewsByUsername(queryMap);
		assertNotNull(rs);
		assertTrue(rs.size() == 2);
	}
	
	@SuppressWarnings("unchecked")
	public void testAddReview() {
		Review r = new Review();
		r.setUser(5L);
		r.setMovie(1L);
		r.setText("test text");
		r.setTitle(null);
		r.setDateAdded(new Date());
		reviewDao.addReview(r);
		
		Map queryMap = new HashMap();
		queryMap.put("movie", 1L);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		assertTrue(reviewDao.getReviewsByMovie(queryMap).size() == 3);
	}
	
	
	@SuppressWarnings("unchecked")
	public void testUpdateReview() {
		Map queryMap = new HashMap();
		queryMap.put("movie", 1L);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		Review r = reviewDao.getReviewsByMovie(queryMap).get(0);
		r.setText("test text");
		r.setTitle(null);
		reviewDao.updateReview(r);
		
		queryMap = new HashMap();
		queryMap.put("movie", 1L);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		assertTrue(reviewDao.getReviewsByMovie(queryMap).get(0).getText().equals("test text"));
	}
	
	
	@SuppressWarnings("unchecked")
	public void testDeleteReview() {
//		Map queryMap = new HashMap();
//		queryMap.put("username", "fubbyo");
//		queryMap.put("movie", 1L);
//		reviewDao.deleteReview(queryMap);
//		
//		queryMap = new HashMap();
//		queryMap.put("movie", 1L);
//		queryMap.put("from", 0);
//		queryMap.put("to", 10);
//		assertTrue(reviewDao.getReviewsByMovie(queryMap).size() == 1);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetReviewOpinions() {
		Map queryMap = new HashMap();
		queryMap.put("username", "freddy");
		queryMap.put("movie", 1L);
		List<OpinionItem> opinions = reviewDao.getReviewOpinions(queryMap);
		assertNotNull(opinions);
		assertTrue(opinions.size() == 3);
	}
	
}