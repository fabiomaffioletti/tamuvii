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
		String messagetext = request.getParameter("messagetext") == null ? null : request.getParameter("messagetext");
		
		if(messagetext == null || messagetext.equals("")) {
			mv.addObject("result", "ko");
		} else {
			messageManager.sendPersonalMessage(sender, receiver, messagetext);
			mv.addObject("result", "ok");
		}
		
		String returnView = request.getParameter("returnView") == null ? null : request.getParameter("returnView");
		if(returnView != null && !returnView.equals("") && returnView.equals("personalMessages"))
			mv.setViewName("redirect:/personalMessages.html?username="+receiver);
		else
			mv.setViewName("aj_sendMessageResult");
		
		
		return mv;
	}

}