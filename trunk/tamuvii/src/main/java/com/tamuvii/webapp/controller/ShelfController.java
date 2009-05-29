package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.AppUserManager;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.RelationshipManager;
import com.tamuvii.service.ShelfManager;
import com.tamuvii.util.TamuviiConstants;

public class ShelfController implements Controller {
	private MovieManager movieManager = null;
	private ShelfManager shelfManager = null;
	private AppUserManager appUserManager = null;
	private RelationshipManager relationshipManager = null;

	public void setAppUserManager(AppUserManager appUserManager) {
		this.appUserManager = appUserManager;
	}
	public void setRelationshipManager(RelationshipManager relationshipManager) {
		this.relationshipManager = relationshipManager;
	}
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
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
			
		// Aggiunge i film della videoteca
		List<ShelfItem> shelfItems = movieManager.getShelfByUsername(username);
		mv.addObject("shelfItems", shelfItems);
		
		// Aggiunge il report sui registi
		mv.addObject("shelfDirectorReportList", shelfManager.getShelfDirectorReport(username, null, null, TamuviiConstants.SHELF_DIRECTOR_REPORT_DEFAULT_ORDER_ATTRIBUTE));
		
		// Aggiunge le informazioni del profilo
		mv.addObject("userPublicInfo", appUserManager.getUserPublicInfo(username));
		mv.addObject("username", username);
		
		// Aggiunge gli amici e i vicini
		mv.addObject("friends", relationshipManager.getUserFriends(username));
		mv.addObject("neighborhoods", relationshipManager.getUserNeighborhoods(username));
		
		mv.setViewName("shelf");
		return mv;
	}
	

}