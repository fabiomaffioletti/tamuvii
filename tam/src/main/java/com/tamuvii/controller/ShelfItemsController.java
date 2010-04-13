package com.tamuvii.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.service.ShelfManager;

public class ShelfItemsController extends ApplicationController implements Controller {
	private ShelfManager shelfManager = null;
	
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String filter = request.getParameter("filter");
		String username = request.getParameter("username");
		
		try {
			String string_page = StringUtils.isEmpty(request.getParameter("page"))?"1":request.getParameter("page");
			Integer page = Integer.parseInt(string_page);
			
			Integer itemsCount = shelfManager.getShelfItemsCount(filter, request.getParameter("username"));
			boolean isLast = (page)*ApplicationConstants.SHELF_ITEMS_PER_PAGE >= itemsCount;
			
			List<ShelfItem> shelfItems = shelfManager.getShelfItems(filter, username, (page-1)*ApplicationConstants.SHELF_ITEMS_PER_PAGE, ApplicationConstants.SHELF_ITEMS_PER_PAGE);  
			if(shelfItems.size() > 0 && !username.equals(request.getRemoteUser()) && !StringUtils.isEmpty(request.getRemoteUser())) {
				shelfItems = shelfManager.getItemsBelongings(request.getRemoteUser(), username, shelfItems);
			}
			
			mv.addObject("shelfItems", shelfItems);
			mv.addObject("filter", filter);
			mv.addObject("itemsCount", itemsCount);
			mv.addObject("isLast", isLast);
			mv.addObject("page", page);
			mv.addObject("username", username);
			
		} catch (Exception e) {
			log.error("Error in getting results for username: "+username + " and filter: "+filter, e);
			saveErrorMessage(request, getText("ajerror.shelf.items", new String[]{username} , request.getLocale()));
		}
		
		mv.setViewName("shelfItems");
		return mv;
	}

}