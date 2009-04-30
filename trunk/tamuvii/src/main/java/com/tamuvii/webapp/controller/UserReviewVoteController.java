package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.UserReviewVoteManager;

public class UserReviewVoteController implements Controller {
	private UserReviewVoteManager userReviewVoteManager = null;
	
	public void setUserReviewVoteManager(UserReviewVoteManager userReviewVoteManager) {
		this.userReviewVoteManager = userReviewVoteManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String username = request.getRemoteUser();
		Integer review = request.getParameter("review") == null ? null : Integer.parseInt(request.getParameter("review"));
		String type = request.getParameter("type") == null ? null : request.getParameter("type");
		int result = 0;
		
		if(type.equals("ok"))
			result = userReviewVoteManager.voteOk(username, review);
		else if(type.equals("ko"))
			result = userReviewVoteManager.voteKo(username, review);
			
		mv.addObject("result", result);
		mv.setViewName("aj_voteReviewResult");
		return mv;
	}

}