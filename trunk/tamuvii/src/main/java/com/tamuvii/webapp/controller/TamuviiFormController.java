package com.tamuvii.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.tamuvii.util.TamuviiConstants;

public class TamuviiFormController extends SimpleFormController {
	private String cancelView;
	
	public final void setCancelView(String cancelView) {  
        this.cancelView = cancelView;  
    }
    public final String getCancelView() {
        return this.cancelView;   
    }

	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, null, true));
		binder.registerCustomEditor(Long.class, null, new CustomNumberEditor(Long.class, null, true));
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		SimpleDateFormat dateFormat = new SimpleDateFormat(getText("date.format", request.getLocale()));
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
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
    
    
    @SuppressWarnings("unchecked")
    public void saveError(HttpServletRequest request, String error) {
        List errors = (List) request.getSession().getAttribute("errors");
        if (errors == null) {
            errors = new ArrayList();
        }
        errors.add(error);
        request.getSession().setAttribute("errors", errors);
    }
    
    @SuppressWarnings("unchecked")
    public void saveTamuviiSuccessMessage(HttpServletRequest request, String msg) {
        List messages = (List) request.getSession().getAttribute(TamuviiConstants.TAMUVII_SUCCESS_MESSAGES);

        if (messages == null) {
            messages = new ArrayList();
        }

        messages.add(msg);
        request.getSession().setAttribute(TamuviiConstants.TAMUVII_SUCCESS_MESSAGES, messages);
    }
}
