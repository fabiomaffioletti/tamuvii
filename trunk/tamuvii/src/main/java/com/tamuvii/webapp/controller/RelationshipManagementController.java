package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.RelationshipManager;

public class RelationshipManagementController implements Controller {
	private RelationshipManager relationshipManager = null;

	public void setRelationshipManager(RelationshipManager relationshipManager) {
		this.relationshipManager = relationshipManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String action = request.getParameter("action") == null ? null : request.getParameter("action");
		String username = request.getParameter("username") == null ? null : request.getParameter("username");
		
		if(action.equals("addFriend")) {
			relationshipManager.addFriend(username, request.getRemoteUser());
			mv.setViewName("redirect:/relationship.html?mode=friends");
		} else if(action.equals("addNeighborhood")) {
			relationshipManager.addNeighborhood(username, request.getRemoteUser());
			mv.setViewName("redirect:/relationship.html?mode=neighborhoods");
		} else if(action.equals("deleteRelationship")) {
			relationshipManager.deleteRelation(username, request.getRemoteUser());
		} else if(action.equals("moveRelationship")) {
			relationshipManager.moveRelation(username, request.getRemoteUser());
		}
		
		return mv;
	}

}