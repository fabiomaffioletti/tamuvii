package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.logging.LoggingUtils;
import com.tamuvii.service.MovieManager;

public class ShelfController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		try {
			mv.addObject("myMovies", movieManager.findMoviesByUsername(request.getRemoteUser()));
			mv.setViewName("shelf");
			return mv;
			
		} catch(Exception e) {
			LoggingUtils.stackTraceToString(e);
			mv.setViewName("genericErrorView");
			return mv;
		}
	}

}
