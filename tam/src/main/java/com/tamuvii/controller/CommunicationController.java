package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.UserManager;

public class CommunicationController implements Controller {
	private UserManager userManager = null;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("users", userManager.getAll(null, null, null));
		
		mv.setViewName("communication");
		return mv;
	}

}