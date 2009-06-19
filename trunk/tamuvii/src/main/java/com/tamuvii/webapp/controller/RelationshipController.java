package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.RelationshipManager;

public class RelationshipController implements Controller {
	private RelationshipManager relationshipManager = null;
	
	public void setRelationshipManager(RelationshipManager relationshipManager) {
		this.relationshipManager = relationshipManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String mode = request.getParameter("mode") == null ? null : request.getParameter("mode");
		
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
		}
		
		if(mode.equals("friends")) {
			//FIXME La sottoquery tira fuori solo parte dei dati della select... lazy loading? come mai???
			mv.addObject("friends", relationshipManager.getUserFriends(username));
			mv.setViewName("friends");
		} else {
			mv.addObject("neighborhoods", relationshipManager.getUserNeighborhoods(username));
			mv.setViewName("neighborhoods");
		}
		
		return mv;
	}

}