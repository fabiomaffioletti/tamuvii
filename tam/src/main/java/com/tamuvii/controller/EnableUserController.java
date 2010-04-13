package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.Authentication;
import org.springframework.security.adapters.PrincipalSpringSecurityUserToken;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import com.tamuvii.model.User;
import com.tamuvii.service.UserManager;

public class EnableUserController extends ApplicationController implements Controller {
	private UserManager userManager = null;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String id = null;
		String email = null;
		try {
			id = request.getParameter("id");
			email = request.getParameter("email");
			
			User user = userManager.getUserById(id);
			if(user.getEmail().equals(email)) {
				userManager.enableUser(id);
				saveSuccessMessage(request, getText("signup.registered.enabled", request.getLocale()));
				UserDetails userDetails = userManager.loadUserByUsername(user.getUsername());
				Authentication authentication = new PrincipalSpringSecurityUserToken(user.getUsername(), user.getUsername(), userDetails.getPassword(), userDetails.getAuthorities(), userDetails);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				mv.setView(new RedirectView("shelf.html"));

			} else {
				log.warn("User with id: "+id +" or email: "+email +" is trying to enable himself with wrong data");
				saveErrorMessage(request, getText("signup.registered.enabled.error", request.getLocale()));
				mv.setView(new RedirectView("signup.html"));
			}
			
		} catch (Exception e) {
			log.warn("User with id: "+id +" or email: "+email +" is trying to enable himself with wrong data");
			saveErrorMessage(request, getText("signup.registered.enabled.error", request.getLocale()));
			mv.setView(new RedirectView("signup.html"));
		}
		
		return mv;
	}

}