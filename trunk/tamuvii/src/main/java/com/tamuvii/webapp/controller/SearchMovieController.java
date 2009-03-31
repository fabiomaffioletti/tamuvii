package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.logging.LoggingUtils;
import com.tamuvii.service.MovieManager;

public class SearchMovieController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		try {
			String filter = request.getParameter("filter") == null ? null : request.getParameter("filter");
			mv.addObject("movieList", movieManager.findMovieByFilter(filter));
			
			mv.setViewName("movieSearchResult");
			return mv;
			
		} catch (Exception e) {
			LoggingUtils.stackTraceToString(e);
			mv.setViewName("genericErrorView");
			return mv;
		}
	}

}