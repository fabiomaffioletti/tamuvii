package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.ExplorePeopleManager;

public class ExplorePeopleController implements Controller {
	private ExplorePeopleManager explorePeopleManager = null;

	public void setExplorePeopleManager(ExplorePeopleManager explorePeopleManager) {
		this.explorePeopleManager = explorePeopleManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("lastSubscribedUsers", explorePeopleManager.getLastSubscribedUsers(request.getRemoteUser()));
		
		mv.setViewName("explorePeople");
		return mv;
	}
	
}