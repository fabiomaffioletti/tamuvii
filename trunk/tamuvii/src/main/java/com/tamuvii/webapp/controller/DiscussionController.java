package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.Discussion;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.service.DiscussionManager;
import com.tamuvii.service.MovieManager;

public class DiscussionController implements Controller {
	private DiscussionManager discussionManager = null;
	private MovieManager movieManager = null;
	
	public void setDiscussionManager(DiscussionManager discussionManager) {
		this.discussionManager = discussionManager;
	}
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Integer review = request.getParameter("review") == null ? null : Integer.parseInt(request.getParameter("review"));
		Discussion discussion = discussionManager.getReviewDiscussion(review);
		mv.addObject("discussion", discussion);
		
		Integer movie = discussion.getDetailedReview().getMovie();
		SocialMovie socialMovie = movieManager.getSocialMovieDetails(movie);
		mv.addObject("socialMovie", socialMovie);
		
		if(request.getRemoteUser() != null) {
			mv.addObject("presentInShelf", movieManager.doesMovieBelongToUserShelf(movie, request.getRemoteUser()));
			mv.addObject("presentInWishlist", movieManager.doesMovieBelongToUserWishlist(movie, request.getRemoteUser()));
		}
		
		mv.setViewName("reviewDiscussion");
		return mv;
	}

}
