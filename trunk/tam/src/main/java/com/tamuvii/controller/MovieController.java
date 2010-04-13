package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.MovieManager;

public class MovieController extends ApplicationController implements Controller {
	private ModelAndView mv = null;
	private MovieManager movieManager = null;
	

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}




	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Entering UserController...");
		mv = new ModelAndView();
		
		try {
			log.debug("Getting movie list...");
			
			mv.addObject("movieList", movieManager.getAllAdmin(request.getParameter("filter")));
			log.debug("Redirecting to view...");
			mv.setViewName("movies");
			
		} catch (Exception e) {
			log.error("Errore nella visualizzazione della lista film", e);
			saveErrorMessage(request, getText("errors.movies.list", request.getLocale()));
			mv.setViewName("users");
		}
		
		return mv;
	}

}