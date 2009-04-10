package com.tamuvii.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.service.MovieManager;

public class PersonalMovieFormController extends BaseFormController {
	private MovieManager movieManager = null;

	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	
	
	public PersonalMovieFormController() {
        setCommandName("personalMovie");
        setCommandClass(PersonalMovie.class);
    }
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {

		if (!isFormSubmission(request)) {
			if (request.getParameter("movie") != null && !"".equals(request.getParameter("movie")) && request.getParameter("cancel") == null) {
				Integer movie = Integer.parseInt(request.getParameter("movie"));
				return movieManager.getPersonalMovieDetails(movie, request.getRemoteUser());

			} else {
				// TODO: in questo caso deve andare in errore, qualcuno sta tentando di aggiungere un nuovo movie non presente
				// tra quelli del db
				return new PersonalMovie();
			}

		}

		return super.formBackingObject(request);
	}

	 
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			return new ModelAndView(getCancelView());
		}

		return super.processFormSubmission(request, response, command, errors);
	}
	

	protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception {
		return super.showForm(request, response, errors);
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		PersonalMovie personalMovie = (PersonalMovie) command;
		Locale locale = request.getLocale();
		
		if (request.getParameter("delete") != null) {
			//TODO fare elimina
            return new ModelAndView(getSuccessView());
            
        } else if(request.getParameter("update") != null) {
        	movieManager.updatePersonalMovieDetails(personalMovie, request.getRemoteUser());
        	return new ModelAndView(getSuccessView());
        }
		
		return showForm(request, response, errors);
	}

}