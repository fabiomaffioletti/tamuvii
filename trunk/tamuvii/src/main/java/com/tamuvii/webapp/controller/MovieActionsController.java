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
		String username = request.getRemoteUser();
		
		try {
			if(request.getParameter("action") != null && !request.getParameter("action").equals("") && request.getParameter("action").equals("add")) {
				Integer movieId = request.getParameter("movieId") == null ? null : Integer.parseInt(request.getParameter("movieId"));
				movieManager.addMovieToUser(movieId, username);
				mv.setViewName("mainMenu");
				return mv;
				
			} else if(request.getParameter("action") != null && !request.getParameter("action").equals("") && request.getParameter("action").equals("delete")) {
				Integer movieId = request.getParameter("movieId") == null ? null : Integer.parseInt(request.getParameter("movieId"));
				movieManager.deleteMovieFromUser(movieId, username);
				mv.setViewName("redirect:/shelf.html");
				return mv;
				
			} else if(request.getParameter("action") != null && !request.getParameter("action").equals("") && request.getParameter("action").equals("details")) {
				Integer movieId = request.getParameter("movieId") == null ? null : Integer.parseInt(request.getParameter("movieId"));
				mv.addObject("movie", movieManager.findMovieById(movieId));
				mv.setViewName("movieSocial");
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
