package com.tamuvii.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.pojo.UserInfo;
import com.tamuvii.service.UserManager;
import com.tamuvii.util.RequestUtils;

public class RelationshipController extends ApplicationController implements Controller {
	private UserManager userManager = null;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String filter = null;
		String username = null;
		String type = request.getParameter("type");
		
		if(type.equals("f")) {
			try {
				String string_page = StringUtils.isEmpty(request.getParameter("page"))?"1":request.getParameter("page");
				Integer page = Integer.parseInt(string_page);
				filter = request.getParameter("filter");
				username = request.getParameter("username");
				Integer itemsCount = userManager.getFriendsCount(RequestUtils.getRequestUsername(username), filter);
				boolean isLast = (page)*ApplicationConstants.FRIENDS_ITEMS_PER_PAGE >= itemsCount;
				
				List<UserInfo> friends = userManager.getFriends(username, (page-1)*ApplicationConstants.FRIENDS_ITEMS_PER_PAGE, ApplicationConstants.FRIENDS_ITEMS_PER_PAGE, ApplicationConstants.ORDER_USERNAME_ASC, filter);
				
				mv.addObject("friends", friends);
				mv.addObject("filter", filter);
				mv.addObject("itemsCount", itemsCount);
				mv.addObject("isLast", isLast);
				mv.addObject("page", page);
				
			} catch (Exception e) {
				log.error("Error in getting friends for user: "+username, e);
				saveErrorMessage(request, getText("ajerror.friends", new String[]{username} , request.getLocale()));
			}
			
			mv.setViewName("friends");
			return mv;
			
		} else {
			
			try {
				String string_page = StringUtils.isEmpty(request.getParameter("page"))?"1":request.getParameter("page");
				Integer page = Integer.parseInt(string_page);
				filter = request.getParameter("filter");
				username = request.getParameter("username");
				Integer itemsCount = userManager.getNearbiesCount(RequestUtils.getRequestUsername(username), filter);
				boolean isLast = (page)*ApplicationConstants.FRIENDS_ITEMS_PER_PAGE >= itemsCount;
				
				List<UserInfo> nearbies = userManager.getNearbies(username, (page-1)*ApplicationConstants.FRIENDS_ITEMS_PER_PAGE, ApplicationConstants.FRIENDS_ITEMS_PER_PAGE, ApplicationConstants.ORDER_USERNAME_ASC, filter);
				
				mv.addObject("nearbies", nearbies);
				mv.addObject("filter", filter);
				mv.addObject("itemsCount", itemsCount);
				mv.addObject("isLast", isLast);
				mv.addObject("page", page);
				
			} catch (Exception e) {
				log.error("Error in getting nearbies for user: "+username, e);
				saveErrorMessage(request, getText("ajerror.nearbies", new String[]{username} , request.getLocale()));
			}
			
			mv.setViewName("nearbies");
			return mv;
			
		}
		
	}

}