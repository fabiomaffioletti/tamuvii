package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.MovieManager;

public class ShelfController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String username = "";
		if(request.getParameter("username") == null)
			if(request.getRemoteUser() == null) {
				//TODO aggiungere il messaggio di errore
				mv.setViewName("genericErrorView");
				return mv;
			}
			else {
				username = request.getRemoteUser();
			}
		else {
			username = request.getParameter("username");
			List<Integer> personalMoviesIds = movieManager.getPersonalMoviesIds(request.getRemoteUser());
			mv.addObject("personalMoviesIds", personalMoviesIds);
			List<Integer> wishedMoviesIds = movieManager.getWishedMoviesIds(request.getRemoteUser());
			mv.addObject("wishedMoviesIds", wishedMoviesIds);
		}
			
		List<ShelfItem> shelfItems = movieManager.getMoviesByUsername(username);
		mv.addObject("shelfItems", shelfItems);
		mv.addObject("username", username);
		mv.setViewName("shelf");
		return mv;
	}
	

}