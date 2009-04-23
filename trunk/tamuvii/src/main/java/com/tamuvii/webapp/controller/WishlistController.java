package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.MovieManager;

public class WishlistController implements Controller {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String username = "";
		if(request.getParameter("username") == null)
			if(request.getRemoteUser() == null) {
				mv.setViewName("redirect:mainMenu.html");
				return mv;
			}
			else {
				username = request.getRemoteUser();
			}
		else {
			username = request.getParameter("username");
			//FIXME Qui non va bene mettere questi...o forse si?
			List<Integer> personalMoviesIds = movieManager.getPersonalMoviesIds(request.getRemoteUser());
			mv.addObject("personalMoviesIds", personalMoviesIds);
		}
			
		List<ShelfItem> wishedItems = movieManager.getWishedMoviesByUsername(username);
		mv.addObject("wishedItems", wishedItems);
		mv.addObject("username", username);
		mv.setViewName("wishlist");
		return mv;
	}
	

}