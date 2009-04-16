package com.tamuvii.webapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.tamuvii.model.Opinion;
import com.tamuvii.service.DiscussionManager;


public class DiscussionFormController extends BaseFormController {
	private DiscussionManager discussionManager;
	
	public void setDiscussionManager(DiscussionManager discussionManager) {
		this.discussionManager = discussionManager;
	}


	public DiscussionFormController() {
        setCommandName("opinion");
        setCommandClass(Opinion.class);
    }
	
	/*
	 * Ogni volta che si apre la pagina della discussione viene mostrata la form vuota, pronta per 
	 * un nuovo inserimento. 
	 */
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		return new Opinion();
	}
	
	
	/*
	 * Mette nella request review su cui si sta discutendo e tutte le opinioni relative. 
	 */
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
		Map refMap = new HashMap();
		Integer movie = request.getParameter("movie") == null ? null : Integer.parseInt(request.getParameter("movie"));
		
		refMap.put("discussion", discussionManager.getReviewDiscussion(movie));
		
		return refMap;
	}
	
	
	
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			return new ModelAndView(getCancelView());
		}

		return super.processFormSubmission(request, response, command, errors);
	}
	

	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
		return super.showForm(request, response, errors);
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		return showForm(request, response, errors);
	}

}