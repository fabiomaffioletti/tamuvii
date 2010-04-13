package com.tamuvii.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.ShelfManager;

public class MovieDirectorController implements Controller {
	private MovieManager movieManager = null;
	private ShelfManager shelfManager = null;
	
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}




	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String string_page = StringUtils.isEmpty(request.getParameter("page"))?"1":request.getParameter("page");
		Integer page = Integer.parseInt(string_page);
		Long id = Long.parseLong(request.getParameter("id"));
		Integer itemsCount = movieManager.getMoviesByDirectorCount(id);
		boolean isLast = (page)*ApplicationConstants.SHELF_ITEMS_PER_PAGE >= itemsCount;
		
		
		List<MovieItem> moviesByDirector = movieManager.getMoviesByDirector(id, (page-1)*ApplicationConstants.MOVIE_DIRECTOR_ITEMS_PER_PAGE, ApplicationConstants.MOVIE_DIRECTOR_ITEMS_PER_PAGE);
		if(moviesByDirector.size() > 0 && !StringUtils.isEmpty(request.getRemoteUser())) {
			moviesByDirector = shelfManager.getItemsBelongings(request.getRemoteUser(), moviesByDirector);
		}
		
		mv.addObject("moviesByDirector", moviesByDirector);
		mv.addObject("id", id);
		mv.addObject("itemsCount", itemsCount);
		mv.addObject("isLast", isLast);
		mv.addObject("page", page);
		
		mv.setViewName("moviesByDirector");
		return mv;
	}

}