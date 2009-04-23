package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.RelationshipManager;

public class ShelfController implements Controller {
	private MovieManager movieManager = null;
	private RelationshipManager relationshipManager = null;

	public void setRelationshipManager(RelationshipManager relationshipManager) {
		this.relationshipManager = relationshipManager;
	}
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
			List<PersonalMovieIdAndWishedFlag> personalMoviesIdsAndWishedFlags = movieManager.getPersonalMoviesIdsAndWishedFlags(request.getRemoteUser());
			mv.addObject("personalMoviesIdsAndWishedFlags", personalMoviesIdsAndWishedFlags);
			boolean areFriends = relationshipManager.areFriends(request.getRemoteUser(), username);
			mv.addObject("areFriends", areFriends);
			if(!areFriends) {
				boolean areNeighborhoods = relationshipManager.areNeighborhoods(request.getRemoteUser(), username);
				mv.addObject("areNeighborhoods", areNeighborhoods);
			}
		}
			
		List<ShelfItem> shelfItems = movieManager.getShelfByUsername(username);
		mv.addObject("shelfItems", shelfItems);
		mv.addObject("username", username);
		mv.setViewName("shelf");
		return mv;
	}
	

}