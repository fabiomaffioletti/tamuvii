package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.service.DirectorManager;
import com.tamuvii.service.MovieManager;

public class DirectorDetailController implements Controller {
	private DirectorManager directorManager = null;
	private MovieManager movieManager = null;

	public void setDirectorManager(DirectorManager directorManager) {
		this.directorManager = directorManager;
	}
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Integer director = request.getParameter("director") == null ? null : Integer.parseInt(request.getParameter("director")); 
		mv.addObject("directorDetail", directorManager.getDirectorDetailById(director));
		
		List<PersonalMovieIdAndWishedFlag> personalMoviesIdsAndWishedFlags = movieManager.getPersonalMoviesIdsAndWishedFlags(request.getRemoteUser());
		mv.addObject("personalMoviesIdsAndWishedFlags", personalMoviesIdsAndWishedFlags);
		
		mv.setViewName("directorDetail");
		return mv;
	}

}