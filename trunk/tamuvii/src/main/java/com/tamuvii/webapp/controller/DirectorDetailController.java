package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.DirectorManager;

public class DirectorDetailController implements Controller {
	private DirectorManager directorManager = null;

	public void setDirectorManager(DirectorManager directorManager) {
		this.directorManager = directorManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Integer director = request.getParameter("director") == null ? null : Integer.parseInt(request.getParameter("director")); 
		mv.addObject("directorDetail", directorManager.getDirectorDetailById(director));
		
		mv.setViewName("directorDetail");
		return mv;
	}

}