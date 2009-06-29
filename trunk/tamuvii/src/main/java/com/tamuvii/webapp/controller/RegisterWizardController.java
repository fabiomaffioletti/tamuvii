package com.tamuvii.webapp.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.tamuvii.service.ConfigManager;
import com.tamuvii.service.MailEngine;
import com.tamuvii.service.RoleManager;
import com.tamuvii.service.UserExistsException;
import com.tamuvii.service.UserManager;
import com.tamuvii.util.TamuviiConstants;
import com.tamuvii.webapp.util.RequestUtil;

public class RegisterWizardController extends AbstractWizardFormController {
	private UserManager userManager;
	private RoleManager roleManager;
	private MailEngine mailEngine;
	private ConfigManager configManager;
	
	public void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}
	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}
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


	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		User user = (User) command;
		user.setEnabled(false);
		user.addRole(roleManager.getRole(Constants.USER_ROLE));
		
		try {
			userManager.saveUser(user);
			Map model = new HashMap();
			model.put("user", user);
			model.put("appURL", RequestUtil.getAppURL(request));
			
			String templateName = "";
			String emailSubject = "";
			try {
				templateName = configManager.getString(TamuviiConstants.NEWREGISTRATIONEMAILTEMPLATE + user.getAddress().getCountry());
				emailSubject = configManager.getString(TamuviiConstants.NEWREGISTRATIONEMAILSUBJECT + user.getAddress().getCountry());
			} catch(NullPointerException npe) {
				templateName = configManager.getString(TamuviiConstants.NEWREGISTRATIONEMAILTEMPLATE + "EN");
				emailSubject = configManager.getString(TamuviiConstants.NEWREGISTRATIONEMAILSUBJECT + "EN");
			}
			
			mailEngine.sendHtmlMessage(null, new String[]{user.getEmail()}, emailSubject, templateName, model);
			
		} catch (AccessDeniedException ade) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null; 
        } catch (UserExistsException e) {
            errors.rejectValue("username", "errors.existing.user", new Object[]{user.getUsername(), user.getEmail()}, "duplicate user");
            user.setPassword(user.getConfirmPassword());
            return showForm(request, response, errors);
        } catch(Exception e) {
        	// FIXME Loggare l'eccezione e tornare una view di errore
        	e.printStackTrace();
        }
		
		return new ModelAndView("register3");
	}
	
}