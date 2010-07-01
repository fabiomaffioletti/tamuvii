package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.ShelfManager;
import com.tamuvii.service.UserManager;

public class MovieItemController extends ApplicationController implements Controller {
	private MovieManager movieManager = null;
	private ShelfManager shelfManager = null;
	private UserManager userManager = null;
	
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String movieId = request.getParameter("id");
		
		try {
			MovieItem movieItem = movieManager.getMovieItem(Long.parseLong(movieId));
			movieItem.setUsers(userManager.getUsersByMovie(movieItem.getMovie().getId(), 0, ApplicationConstants.MOVIE_USERS_MOVIE_ITEM_PAGE));
			movieItem.setUsersCount(userManager.getUsersByMovieCount(movieItem.getMovie().getId()));
			movieItem.setReviews(movieManager.getReviewItemsByMovie(movieItem.getMovie().getId(), 0, ApplicationConstants.MOVIE_REVIEW_ITEMS_PER_PAGE));
			
			if(movieItem != null && !StringUtils.isEmpty(request.getRemoteUser())) {
				movieItem = shelfManager.getSingleItemBelongings(request.getRemoteUser(), movieItem);
				movieItem.setFriendsCount(userManager.getFriendsByMovieCount(movieItem.getMovie().getId(), request.getRemoteUser()));
				movieItem.setNearbiesCount(userManager.getNearbiesByMovieCount(movieItem.getMovie().getId(), request.getRemoteUser()));
			}
			
			mv.addObject("movieItem", movieItem);
			
		} catch (Exception e) {
			log.error("Error in getting results for movie: "+movieId, e);
			saveErrorMessage(request, getText("ajerror.movie.item" , request.getLocale()));
		}
		
		mv.setViewName("movieItem");
		return mv;
	}

}