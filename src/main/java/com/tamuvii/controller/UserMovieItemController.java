package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.UserMovieManager;

public class UserMovieItemController extends ApplicationController implements Controller {
	private UserMovieManager userMovieManager = null;

	public void setUserMovieManager(UserMovieManager userMovieManager) {
		this.userMovieManager = userMovieManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String movie = null;
		
		try {
			movie = request.getParameter("movie");

			ShelfItem userMovieItem = userMovieManager.getUserMovieByMovieId(request.getRemoteUser(), Long.parseLong(movie));
			mv.addObject("userMovieItem", userMovieItem);
		} catch (Exception e) {
			log.error("Error in getting movie item for modifying it for username: "+request.getRemoteUser()+ " and movie: "+movie, e);
			saveErrorMessage(request, getText("ajerror.movie.item.modify", request.getLocale()));
		}
		
		mv.setViewName("userMovieItem");
		return mv;
	}

}
