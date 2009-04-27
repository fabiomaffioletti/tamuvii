package com.tamuvii.util;

import com.tamuvii.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ApplicationObjectSupport;

public class InternationalizationUtilities extends ApplicationObjectSupport {
	
	@SuppressWarnings("unchecked")
    public void saveError(HttpServletRequest request, String error) {
        List errors = (List) request.getSession().getAttribute(Constants.ERRORS_KEY);
        if (errors == null) {
            errors = new ArrayList();
        }
        errors.add(error);
        request.getSession().setAttribute(Constants.ERRORS_KEY, errors);
    }
	
	@SuppressWarnings("unchecked")
    public void saveMessage(HttpServletRequest request, String msg) {
        List messages = (List) request.getSession().getAttribute(Constants.MESSAGES_KEY);

        if (messages == null) {
            messages = new ArrayList();
        }

        messages.add(msg);
        request.getSession().setAttribute(Constants.MESSAGES_KEY, messages);
    }
	
	public String getText(String msgKey, Locale locale) {
        return getMessageSourceAccessor().getMessage(msgKey, locale);
    }
	
	public String getText(String msgKey, Locale locale, Object[] param) {
        return getMessageSourceAccessor().getMessage(msgKey, param, locale);
    }

}
