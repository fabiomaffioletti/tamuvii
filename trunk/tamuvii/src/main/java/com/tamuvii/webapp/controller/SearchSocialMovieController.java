package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.MovieManager;

public class SearchSocialMovieController implements Controller {
	private MovieManager movieManager = null;

	public MovieManager getMovieManager() {
		return movieManager;
	}

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String filter = request.getParameter("filter") == null ? null : request.getParameter("filter"); 
		mv.addObject("resultSocialMovies", movieManager.searchSocialMovie(request.getRemoteUser(), filter));
		mv.addObject("filter", filter);
		
		mv.setViewName("resultSocialMovies");
		return mv;
	}

}