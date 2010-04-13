package com.tamuvii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.pojo.UserInfo;
import com.tamuvii.service.ShelfManager;

public class ShelfController implements Controller {
	private ShelfManager shelfManager = null;
	
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String username = StringUtils.isEmpty(request.getParameter("username"))?request.getRemoteUser():request.getParameter("username");
		UserInfo userInfo = shelfManager.getUserInfo(username);
		if(!username.equals(request.getRemoteUser())) {
			mv.addObject("relationship", shelfManager.getRelationship(request.getRemoteUser(), username));
		}
		
		
		mv.addObject("userInfo", userInfo);
		
		mv.setViewName("shelf");
		return mv;
	}

}