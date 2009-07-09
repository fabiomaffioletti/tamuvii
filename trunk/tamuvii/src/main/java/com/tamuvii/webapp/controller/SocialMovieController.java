package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.service.MovieManager;

public class SocialMovieController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Integer movie = request.getParameter("movie") == null ? null : Integer.parseInt(request.getParameter("movie"));
		
		SocialMovie socialMovie = movieManager.getSocialMovieDetails(movie, request.getRemoteUser()); 
		
		mv.addObject("socialMovie", socialMovie);
		
		if(request.getRemoteUser() != null) {
			mv.addObject("presentInShelf", movieManager.doesMovieBelongToUserShelf(movie, request.getRemoteUser()));
			mv.addObject("presentInWishlist", movieManager.doesMovieBelongToUserWishlist(movie, request.getRemoteUser()));
		}
		
		mv.setViewName("socialMovie");
		return mv;
	}
	

}