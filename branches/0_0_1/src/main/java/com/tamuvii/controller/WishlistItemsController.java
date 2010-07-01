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

public class WishlistItemsController implements Controller {
	private ShelfManager shelfManager = null;
	
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String string_page = StringUtils.isEmpty(request.getParameter("page"))?"1":request.getParameter("page");
		Integer page = Integer.parseInt(string_page);
		String filter = request.getParameter("filter");
		String username = request.getParameter("username");
		Integer itemsCount = shelfManager.getWishlistItemsCount(filter, request.getParameter("username"));
		boolean isLast = (page)*ApplicationConstants.SHELF_ITEMS_PER_PAGE >= itemsCount;
		
		List<ShelfItem> wishlistItems = shelfManager.getWishlistItems(filter, username, (page-1)*ApplicationConstants.SHELF_ITEMS_PER_PAGE, ApplicationConstants.SHELF_ITEMS_PER_PAGE);;  
		if(wishlistItems.size() > 0 && !username.equals(request.getRemoteUser()) && !StringUtils.isEmpty(request.getRemoteUser())) {
			wishlistItems = shelfManager.getItemsBelongings(request.getRemoteUser(), username, wishlistItems);
		}
		
		mv.addObject("wishlistItems", wishlistItems);
		mv.addObject("filter", filter);
		mv.addObject("itemsCount", itemsCount);
		mv.addObject("isLast", isLast);
		mv.addObject("page", page);
		mv.addObject("username", username);
		
		mv.setViewName("wishlistItems");
		return mv;
	}

}