package com.tamuvii.webapp.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.tamuvii.model.AppUser;
import com.tamuvii.service.AppUserManager;
import com.tamuvii.util.Utilities;

public class UserProfileFormController extends TamuviiFormController {
	private AppUserManager appUserManager = null;
	
	public void setAppUserManager(AppUserManager appUserManager) {
		this.appUserManager = appUserManager;
	}


	public UserProfileFormController() {
        setCommandName("appUser");
        setCommandClass(AppUser.class);
    }
	
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
        if (!isFormSubmission(request)) {
        	return appUserManager.getUserByUsername(request.getRemoteUser());
        } else {
        	return super.formBackingObject(request);
        }
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		AppUser appUser = (AppUser) command;
		
		try {
			appUserManager.saveUser(appUser);
			saveTamuviiSuccessMessage(request, "Ecco il tuo profilo aggiornato!");
			
		} catch(Exception e) {
			//TODO Loggare l'eccezione e mandare a una view di errore.
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/preferences.html");
	}
	
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("language", request.getLocale());
		return data;
	}
	
}