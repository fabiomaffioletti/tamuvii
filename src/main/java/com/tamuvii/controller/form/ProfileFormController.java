package com.tamuvii.controller.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tamuvii.exception.UserExistsException;
import com.tamuvii.model.User;
import com.tamuvii.service.UserManager;

public class ProfileFormController extends ApplicationFormController {
	private UserManager userManager = null;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public ProfileFormController() {
        setCommandName("profile");
        setCommandClass(User.class);
    }
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		if (!isFormSubmission(request)) {
			User user = userManager.getUserByUsername(request.getRemoteUser());
			user.setConfirmPassword(user.getPassword());
			return user;
		}
		
		return new User();
	}
	
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			log.debug("Not modifying user...");
			return new ModelAndView(new RedirectView("shelf.html"));
		}
		return super.processFormSubmission(request, response, command, errors);
	}

	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		User user = (User) command;
		
		User prevUser = userManager.getUserById(String.valueOf(user.getId()));
		BeanUtils.copyProperties(user, prevUser, new String[]{	"username", 
																"dateAdded", 
																"enabled", 
																"accountExpired", 
																"accountLocked", 
																"credentialsExpired", 
																"avatar", 
																"roles"
															});
		
		try {
			userManager.saveUser(prevUser);
		
		} catch(UserExistsException e) {
			errors.rejectValue("email", "errors.existing.user.email", new Object[] {user.getEmail()}, "duplicate user");
			user.setPassword(user.getConfirmPassword());
			return showForm(request, response, errors);
			
		} catch(Exception e) {
			saveErrorMessage(request, getText("errors.generic", request.getLocale()));
			log.error("Errore nel salvataggio di un utente: "+user.getUsername(), e);
			return showForm(request, response, errors);
		}
		
		return new ModelAndView(new RedirectView("/profile.html"));
		
	}

}