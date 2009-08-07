package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.service.MovieManager;
import com.tamuvii.util.TamuviiConstants;

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
		
		String username = request.getRemoteUser();
		
		List<PersonalMovieIdAndWishedFlag> personalMoviesIdsAndWishedFlags = movieManager.getPersonalMoviesIdsAndWishedFlags(request.getRemoteUser());

		mv.addObject("personalMoviesIdsAndWishedFlags", personalMoviesIdsAndWishedFlags);		
		
		mv.addObject("results", movieManager.searchSocialMovies(username, null, true, TamuviiConstants.MOVIES_INITIAL_PAGE));
		mv.addObject("currentPage", TamuviiConstants.MOVIES_INITIAL_PAGE);
		mv.addObject("username", username);
		mv.setViewName("search");
		
		return mv;
	}

}