package com.tamuvii.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.Shelf;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.service.AppUserManager;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.RelationshipManager;
import com.tamuvii.service.ShelfManager;
import com.tamuvii.service.VisitManager;
import com.tamuvii.util.TamuviiConstants;

public class ShelfController implements Controller {
	private MovieManager movieManager = null;
	private ShelfManager shelfManager = null;
	private AppUserManager appUserManager = null;
	private RelationshipManager relationshipManager = null;
	private VisitManager visitManager = null;

	public void setVisitManager(VisitManager visitManager) {
		this.visitManager = visitManager;
	}
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
			// L'utente sta visualizzando la videoteca di un altro (o di se stesso se username = remoteUser)
			username = request.getParameter("username");
			List<PersonalMovieIdAndWishedFlag> personalMoviesIdsAndWishedFlags = movieManager.getPersonalMoviesIdsAndWishedFlags(request.getRemoteUser());
			mv.addObject("personalMoviesIdsAndWishedFlags", personalMoviesIdsAndWishedFlags);
			boolean areFriends = relationshipManager.areFriends(request.getRemoteUser(), username);
			mv.addObject("areFriends", areFriends);
			if(!areFriends) {
				boolean areNeighborhoods = relationshipManager.areNeighborhoods(request.getRemoteUser(), username);
				mv.addObject("areNeighborhoods", areNeighborhoods);
			}
			
			// Aggiungo un record alle visite solo se username != remoteUser
			if(!username.equals(request.getRemoteUser()))
				visitManager.addUserVisit(username, request.getRemoteUser());
		}
		
		mv.addObject("username", username);
		
		// Aggiunge le informazioni del profilo
		UserNeighbor un = appUserManager.getUserPublicInfo(username);
		mv.addObject("userPublicInfo", un);
			
		// Aggiunge i film della videoteca
		Shelf shelf = new Shelf();
		shelf = shelfManager.getShelf(username, null, TamuviiConstants.MOVIES_DEFAULT_ORDER_ATTRIBUTE, TamuviiConstants.ORDER_DESC, TamuviiConstants.MOVIES_INITIAL_PAGE);
		mv.addObject("shelf", shelf);
		mv.addObject("currentPage", TamuviiConstants.MOVIES_INITIAL_PAGE);
		
		// Aggiunge il report sui registi
		mv.addObject("shelfDirectorReportList", shelfManager.getShelfDirectorReport(username, null, null, TamuviiConstants.SHELF_DIRECTOR_REPORT_DEFAULT_ORDER_ATTRIBUTE));
		
		// Aggiunge gli amici e i vicini
		mv.addObject("friends", relationshipManager.getUserFriends(username));
		mv.addObject("neighborhoods", relationshipManager.getUserNeighborhoods(username));
		
		mv.setViewName("shelf");
		return mv;
	}
	

}