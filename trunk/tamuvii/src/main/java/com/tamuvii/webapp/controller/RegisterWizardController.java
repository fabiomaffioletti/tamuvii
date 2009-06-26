package com.tamuvii.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import org.springmodules.validation.commons.PageAware;

import com.tamuvii.Constants;
import com.tamuvii.model.User;
import com.tamuvii.service.RoleManager;
import com.tamuvii.service.UserExistsException;
import com.tamuvii.service.UserManager;

public class RegisterWizardController extends AbstractWizardFormController {
	private UserManager userManager;
	private RoleManager roleManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}


	public RegisterWizardController() {
		setCommandName("user");
		setCommandClass(User.class);
	}
	
	protected void validatePage(Object command, Errors errors, int page) {
        Validator[] validators = getValidators();
        for (int i=0; i<validators.length; i++) {
            Validator validator = validators[i];
            if (validator instanceof PageAware) {
                if (((PageAware)validator).getPage() == page) {
                    validator.validate(command, errors);
                }
            }
        }
    }


	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		User user = (User) command;
		user.setEnabled(false);
		user.addRole(roleManager.getRole(Constants.USER_ROLE));
		
		try {
			userManager.saveUser(user);
		} catch (AccessDeniedException ade) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null; 
        } catch (UserExistsException e) {
            errors.rejectValue("username", "errors.existing.user", new Object[]{user.getUsername(), user.getEmail()}, "duplicate user");
            user.setPassword(user.getConfirmPassword());
            return showForm(request, response, errors);
        }
		
		return new ModelAndView("register2");
	}
	
}