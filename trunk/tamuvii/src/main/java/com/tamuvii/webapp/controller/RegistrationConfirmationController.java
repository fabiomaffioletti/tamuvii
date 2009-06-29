package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.AppUserManager;

public class RegistrationConfirmationController implements Controller {
	private AppUserManager appUserManager;

	public void setAppUserManager(AppUserManager appUserManager) {
		this.appUserManager = appUserManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String userEmail = request.getParameter("e") == null ? null : request.getParameter("e");
		if(userEmail != null) {
			appUserManager.enableUser(userEmail);
			mv.setViewName("registrationConfirmed");
		} else {
			//TODO vai a una view di errore...
		}
		
		return mv;
	}

}