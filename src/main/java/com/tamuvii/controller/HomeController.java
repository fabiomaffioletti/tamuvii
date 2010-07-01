package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.service.ShelfManager;

public class HomeController implements Controller {
	private ShelfManager shelfManager = null;

	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("userInfo", shelfManager.getUserInfo(request.getRemoteUser()));
		mv.addObject("lastInserted", shelfManager.getAllItems(request.getRemoteUser(), 0, ApplicationConstants.HOME_LAST_INSERTED));
		mv.addObject("lastRegistered", shelfManager.getLastRegistered(ApplicationConstants.HOME_LAST_REGISTERED));
		mv.addObject("lastAdded", shelfManager.getLastAdded(ApplicationConstants.HOME_LAST_ADDED));
		
		mv.setViewName("home");
		return mv;
	}
	
}