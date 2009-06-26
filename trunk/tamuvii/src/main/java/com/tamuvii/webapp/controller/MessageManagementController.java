package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.tamuvii.service.MessageManager;

public class MessageManagementController implements Controller {
	private MessageManager messageManager = null;
	
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}



	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		String receiver = request.getParameter("receiver") == null ? null : request.getParameter("receiver");
		String sender = request.getRemoteUser();
		String messageReplyText = request.getParameter("message_reply_text") == null ? null : request.getParameter("message_reply_text");
		
		messageManager.sendPersonalMessage(sender, receiver, messageReplyText);
		
		mv.setViewName("redirect:/personalMessages.html?username="+receiver);
		return mv;
	}

}