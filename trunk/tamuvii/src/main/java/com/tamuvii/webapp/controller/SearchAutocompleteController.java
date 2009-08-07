package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.MovieManager;

public class SearchAutocompleteController implements Controller {
	
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String searchString = request.getParameter("searchString") == null ? null : request.getParameter("searchString");
		mv.addObject("searchResults", movieManager.searchSocialMovies(request.getRemoteUser(),searchString, false, 0));
		mv.setViewName("searchAutocompleteResult");
		return mv;
	}

}