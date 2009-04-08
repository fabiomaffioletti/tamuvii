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
		
		Integer movieId = request.getParameter("movieId") == null ? null : Integer.parseInt(request.getParameter("movieId"));
		
		SocialMovie socialMovie = movieManager.getSocialMovieDetails(movieId); 
		
		mv.addObject("socialMovie", socialMovie);
		
		mv.setViewName("socialMovie");
		return mv;
	}
	

}