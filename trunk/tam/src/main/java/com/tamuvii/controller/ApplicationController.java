package com.tamuvii.controller;

import com.tamuvii.ApplicationConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ApplicationObjectSupport;

public abstract class ApplicationController extends ApplicationObjectSupport {
	protected final Log log = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public void saveErrorMessage(HttpServletRequest request, String error) {
        List errorMessages = (List) request.getSession().getAttribute(ApplicationConstants.ERROR_MESSAGES);
        if (errorMessages == null) {
        	errorMessages = new ArrayList();
        }
        errorMessages.add(error);
        request.getSession().setAttribute(ApplicationConstants.ERROR_MESSAGES, errorMessages);
    }
	
	@SuppressWarnings("unchecked")
	public void saveSuccessMessage(HttpServletRequest request, String message) {
        List successMessages = (List) request.getSession().getAttribute(ApplicationConstants.SUCCESS_MESSAGES);
        if (successMessages == null) {
        	successMessages = new ArrayList();
        }
        successMessages.add(message);
        request.getSession().setAttribute(ApplicationConstants.SUCCESS_MESSAGES, successMessages);
    }
	
	@SuppressWarnings("unchecked")
	public void saveInfoMessage(HttpServletRequest request, String msg) {
        List infoMessages = (List) request.getSession().getAttribute(ApplicationConstants.INFO_MESSAGES);
        if (infoMessages == null) {
        	infoMessages = new ArrayList();
        }
        infoMessages.add(msg);
        request.getSession().setAttribute(ApplicationConstants.INFO_MESSAGES, infoMessages);
    }
	
	public String getText(String msgKey, Locale locale) {
        return getMessageSourceAccessor().getMessage(msgKey, locale);
    }
	
    public String getText(String msgKey, String arg, Locale locale) {
        return getText(msgKey, new Object[] { arg }, locale);
    }
    
    public String getText(String msgKey, Object[] args, Locale locale) {
        return getMessageSourceAccessor().getMessage(msgKey, args, locale);
    }
}