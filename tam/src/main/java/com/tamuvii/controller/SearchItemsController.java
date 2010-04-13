package com.tamuvii.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.ShelfManager;

public class SearchItemsController extends ApplicationController implements Controller {
	private MovieManager movieManager = null;
	private ShelfManager shelfManager = null;
	
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String filter = null;
		try {
			String string_page = StringUtils.isEmpty(request.getParameter("page"))?"1":request.getParameter("page");
			Integer page = Integer.parseInt(string_page);
			filter = request.getParameter("filter");
			Integer itemsCount = movieManager.getAllCount(filter);
			boolean isLast = (page)*ApplicationConstants.SHELF_ITEMS_PER_PAGE >= itemsCount;
			
			List<MovieItem> movieItems = movieManager.getAll(filter, (page-1)*ApplicationConstants.SEARCH_ITEMS_PER_PAGE, ApplicationConstants.SEARCH_ITEMS_PER_PAGE);
			if(movieItems.size() > 0 && !StringUtils.isEmpty(request.getRemoteUser())) {
				movieItems = shelfManager.getItemsBelongings(request.getRemoteUser(), movieItems);
			}
			
			mv.addObject("movieItems", movieItems);
			mv.addObject("filter", filter);
			mv.addObject("itemsCount", itemsCount);
			mv.addObject("isLast", isLast);
			mv.addObject("page", page);
			
		} catch (Exception e) {
			log.error("Error in getting results for filter: "+filter, e);
			saveErrorMessage(request, getText("ajerror.search", new String[]{filter} , request.getLocale()));
		}
		
		mv.setViewName("searchItems");
		return mv;
	}

}