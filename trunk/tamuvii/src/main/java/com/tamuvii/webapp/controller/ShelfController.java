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
		List<ShelfItem> shelfItems = movieManager.getMoviesByUsername(request.getRemoteUser()); 
		mv.addObject("shelfItems", shelfItems);
		mv.setViewName("shelf");
		return mv;
	}
	

}