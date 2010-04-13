package com.tamuvii.controller;

import com.tamuvii.service.UserManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController extends ApplicationController implements Controller {
	private ModelAndView mv = null;
	private UserManager userManager = null;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("Entering UserController...");
		mv = new ModelAndView();
		
		try {
			log.debug("Getting user list...");
			
			mv.addObject("userList", userManager.getAll(request.getParameter("filter"), null, null));
			log.debug("Redirecting to view...");
			mv.setViewName("users");
			
		} catch (Exception e) {
			log.error("Errore nella visualizzazione della lista utenti", e);
			saveErrorMessage(request, getText("errors.user.list", request.getLocale()));
			mv.setViewName("home");
		}
		
		return mv;
	}

}