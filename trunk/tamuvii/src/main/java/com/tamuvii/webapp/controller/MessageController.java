package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.MessageManager;

public class MessageController implements Controller {
	private MessageManager messageManager = null;
	
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("groupedMessages", messageManager.getGroupedMessagesByUser(request.getRemoteUser()));
		
		if(request.getParameter("username") == null)
			mv.addObject("allMessages", messageManager.getInMessagesByUser(request.getRemoteUser()));
		else {
			mv.addObject("allMessages", messageManager.getConversationWithUser(request.getRemoteUser(), request.getParameter("username")));
			mv.addObject("username", request.getParameter("username"));
			mv.addObject("conversation", true);
		}
		
		mv.setViewName("personalMessages");
		return mv;
	}

}