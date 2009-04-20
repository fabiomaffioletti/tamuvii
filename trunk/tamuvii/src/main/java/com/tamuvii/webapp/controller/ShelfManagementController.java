package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.MovieManager;

public class ShelfManagementController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Integer movie = request.getParameter("movie") == null ? null : Integer.parseInt(request.getParameter("movie"));
		
		if(request.getParameter("action") != null && request.getParameter("action").equals("add")) {
			movieManager.addMovieToShelf(movie, request.getRemoteUser());
			mv.setViewName("redirect:/personalMovie.html?movie="+movie);
		} else if(request.getParameter("action") != null && request.getParameter("action").equals("wish")) {
			movieManager.addMovieToWishlist(movie, request.getRemoteUser());
			//FIXME Mettere un'altra view più il controllo che non possa modificare la review e il voto senza prima
			//averlo aggiunto alla shelf...
			mv.setViewName("redirect:/wishlist.html");
		}
		return mv;
	}

}