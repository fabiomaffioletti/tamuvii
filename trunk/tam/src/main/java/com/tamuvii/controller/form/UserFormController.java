package com.tamuvii.controller.form;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.exception.UserExistsException;
import com.tamuvii.model.User;
import com.tamuvii.service.RoleManager;
import com.tamuvii.service.UserManager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class UserFormController extends ApplicationFormController {
	private UserManager userManager;
    private RoleManager roleManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }
	
	
	public UserFormController() {
        setCommandName("user");
        setCommandClass(User.class);
    }
	
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
    	Map m = new HashMap();
    	m.put("roles", roleManager.getAll());
		return m;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
        
		if (!isFormSubmission(request)) {
        	User user;
        	
        	if (id == null && !isAdd(request)) {
        		user = userManager.getUserByUsername(request.getRemoteUser());
        	} else if (!StringUtils.isBlank(id)) {
        		 user = userManager.getUserById(id);
        	} else {
        		user = new User();
        		user.addRole(roleManager.getRoleByName(ApplicationConstants.ROLE_USER));
        	}
        	
        	user.setConfirmPassword(user.getPassword());
            return user;

		} else {
			User user = new User();
			user.addRole(roleManager.getRoleByName(ApplicationConstants.ROLE_USER));
			return user;
		}
	}
	
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			log.debug("Not modifying nor deleting user...");
			if (StringUtils.equals(request.getParameter("from"), "list")) {
				return new ModelAndView(new RedirectView("users.html"));
			} else {
				saveInfoMessage(request, getText("info.updates.not.committed", request.getLocale()));
				return new ModelAndView(new RedirectView("userForm.html"));
			}
		}
		return super.processFormSubmission(request, response, command, errors);
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		User user = (User) command;
		
		if (request.getParameter("delete") != null) {
			log.debug("Trying to delete user: "+user.getId());
			userManager.removeUser(user.getId().toString());
			saveSuccessMessage(request, getText("success.user.removed", request.getLocale()));
			
		} else {
			String[] userRoles = request.getParameterValues("role");
			user.getRoles().clear();
			if(userRoles != null)
				for (String id : userRoles) {
					user.addRole(roleManager.getRoleById(id));
				}
			else
				user.addRole(roleManager.getRoleByName(ApplicationConstants.ROLE_USER));
			
			try {
				log.debug("Trying to save user with username: "+user.getUsername());
				user = userManager.saveUser(user);
				saveSuccessMessage(request, getText("success.user.saved", request.getLocale()));
				log.debug("User "+user.getUsername() + " saved. Id: "+user.getId());
				 
			} catch(UserExistsException e) {
				errors.rejectValue("username", "errors.existing.user", new Object[] {user.getUsername(), user.getEmail()}, "duplicate user");
				user.setPassword(user.getConfirmPassword());
				return showForm(request, response, errors);
				
			} catch(Exception e) {
				saveErrorMessage(request, getText("errors.generic", request.getLocale()));
				log.error("Errore nel salvataggio di un utente", e);
			} 
			
		}
		
		if (StringUtils.equals(request.getParameter("from"), "list")) {
			return new ModelAndView(new RedirectView("users.html"));
			
		} else {
			return showForm(request, response, errors);
		}
		
	}
	
	protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
	
}