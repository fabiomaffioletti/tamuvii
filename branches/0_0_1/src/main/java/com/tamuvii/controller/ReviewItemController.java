package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.ReviewItem;
import com.tamuvii.service.ReviewManager;

public class ReviewItemController extends ApplicationController implements Controller {
	private ReviewManager reviewManager = null;

	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String movie = request.getParameter("movie");
		String username = request.getParameter("username");
		
		try {
			ReviewItem reviewItem = reviewManager.getReviewItemByMovieAndUsername(Long.parseLong(movie), username);
			reviewItem.setOpinions(reviewManager.getReviewOpinions(Long.parseLong(movie), username));
			mv.addObject("reviewItem", reviewItem);
			
		} catch (Exception e) {
			log.error("Error in getting results for review with movie: "+movie+" and user "+username, e);
			saveErrorMessage(request, getText("ajerror.review.item" , request.getLocale()));
		}
		
		mv.setViewName("reviewItem");
		return mv;
	}

}