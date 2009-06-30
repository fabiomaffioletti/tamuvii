package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.AppUserManager;
import com.tamuvii.service.RelationshipManager;
import com.tamuvii.service.ShelfManager;
import com.tamuvii.service.VisitManager;
import com.tamuvii.util.TamuviiConstants;

public class StatisticsController implements Controller {
	private AppUserManager appUserManager = null;
	private ShelfManager shelfManager = null;
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
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}
	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String username = request.getRemoteUser();
		
		// Aggiunge gli ultimi visitatori della libreria dell'utente
		mv.addObject("lastVisitors", visitManager.getLastUserVisitors(username));
		
		// Aggiunge il report sui registi
		mv.addObject("shelfDirectorReportList", shelfManager.getShelfDirectorReport(username, null, null, TamuviiConstants.SHELF_DIRECTOR_REPORT_DEFAULT_ORDER_ATTRIBUTE));
		
		// Aggiunge le informazioni del profilo
		mv.addObject("userPublicInfo", appUserManager.getUserPublicInfo(username));
		mv.addObject("username", username);
		
		// Aggiunge gli amici e i vicini
		mv.addObject("friends", relationshipManager.getUserFriends(username));
		mv.addObject("neighborhoods", relationshipManager.getUserNeighborhoods(username));
		
		mv.setViewName("statistics");
		return mv;
	}
	

}