package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.model.Opinion;
import com.tamuvii.service.OpinionManager;

public class OpinionController implements Controller {
	private OpinionManager opinionManager = null;

	public void setOpinionManager(OpinionManager opinionManager) {
		this.opinionManager = opinionManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equals("delete")) {
				Integer opinionId = request.getParameter("opinion") == null ? null : Integer.parseInt(request.getParameter("opinion"));
				Opinion opinion = opinionManager.doesOpinionBelongToUser(opinionId, request.getRemoteUser());
				if(opinion != null) {
					opinionManager.deleteOpinion(opinion);
					return new ModelAndView("redirect:/reviewDiscussion.html?review="+opinion.getReview());
				} else {
					return new ModelAndView("genericErrorView");
				}
				
			}
			
		}
		
		return null;
	}

}
