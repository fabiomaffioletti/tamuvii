package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.logging.LoggingUtils;
import com.tamuvii.service.MovieManager;

public class MovieActionsController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		try {
			if(request.getParameter("action") != null && !request.getParameter("action").equals("") && request.getParameter("action").equals("add")) {
				String username = request.getRemoteUser();
				Integer movie = request.getParameter("movieId") == null ? null : Integer.parseInt(request.getParameter("movieId"));
				movieManager.addMovieToUser(movie, username);
				
				mv.setViewName("mainMenu");
				return mv;
			}
			else {
				mv.setViewName("mainMenu");
				return mv;
			}
		} catch (Exception e) {
			LoggingUtils.stackTraceToString(e);
			mv.setViewName("genericErrorView");
			return mv;
		}
		
	}
	

}
