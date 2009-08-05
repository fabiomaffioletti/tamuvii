package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.service.MovieManager;

public class SocialMovieController implements Controller {
	protected final Log log = LogFactory.getLog(getClass());
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
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
			
		} catch (Exception e) {
			log.error("Error in getting social movie data", e);
			// TODO creare una view di errore specifica... "error" non va bene...
			return new ModelAndView("error");
		}
	}
	

}