package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.ShelfManager;
import com.tamuvii.util.TamuviiConstants;

public class JSONController implements Controller {
	private ShelfManager shelfManager = null;

	public void setShelfManager(ShelfManager shelfManager) {
		this.shelfManager = shelfManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Integer page = Integer.parseInt(request.getParameter("page"));
		String username = request.getParameter("username");
		mv.addObject("result", shelfManager.getJSONShelfDirectorReport(username, page * TamuviiConstants.SHELF_DIRECTOR_REPORT_RECORD_PER_PAGE, TamuviiConstants.SHELF_DIRECTOR_REPORT_RECORD_PER_PAGE));
		mv.setViewName("aj_jsonResult");
		return mv;
	}

}