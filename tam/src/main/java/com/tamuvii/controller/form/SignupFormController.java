package com.tamuvii.controller.form;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.exception.UserExistsException;
import com.tamuvii.model.User;
import com.tamuvii.service.RoleManager;
import com.tamuvii.service.UserManager;
import com.tamuvii.util.RequestUtils;

public class SignupFormController extends ApplicationFormController {
	private UserManager userManager;
    private RoleManager roleManager;
    
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }
	
	
	public SignupFormController() {
        setCommandName("user");
        setCommandClass(User.class);
    }
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		User user = new User();
		user.addRole(roleManager.getRoleByName(ApplicationConstants.ROLE_USER));
    	user.setConfirmPassword(user.getPassword());
        return user;
	}
	
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		return super.processFormSubmission(request, response, command, errors);
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		User user = (User) command;
		
		user.addRole(roleManager.getRoleByName(ApplicationConstants.ROLE_USER));
		user.setDateAdded(new Date());
			
		try {
			log.debug("Trying to save user with username: "+user.getUsername());
			user = userManager.registerUser(user, RequestUtils.getAppURL(request));
			saveSuccessMessage(request, getText("signup.registered.success", request.getLocale()));
			log.debug("User "+user.getUsername() + " saved. Id: "+user.getId());
			
			return new ModelAndView("registered");
			 
		} catch(UserExistsException e) {
			errors.rejectValue("username", "errors.existing.user", new Object[] {user.getUsername(), user.getEmail()}, "duplicate user");
			user.setPassword(user.getConfirmPassword());
			return showForm(request, response, errors);
			
		} catch(Exception e) {
			saveErrorMessage(request, getText("errors.generic", request.getLocale()));
			log.error("Errore nel salvataggio di un utente: "+user.getUsername(), e);
			return showForm(request, response, errors);
		} 
			
	}
	
	protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
	
}