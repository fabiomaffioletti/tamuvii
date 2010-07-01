package com.tamuvii.controller.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.model.Genre;
import com.tamuvii.model.Movie;
import com.tamuvii.service.DirectorManager;
import com.tamuvii.service.GenreManager;
import com.tamuvii.service.MovieManager;

public class MovieFormController extends ApplicationFormController {
	private MovieManager movieManager = null;
	private DirectorManager directorManager = null;
	private GenreManager genreManager = null;
	
	public void setGenreManager(GenreManager genreManager) {
		this.genreManager = genreManager;
	}
	public void setDirectorManager(DirectorManager directorManager) {
		this.directorManager = directorManager;
	}
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	

	public MovieFormController() {
        setCommandName("movie");
        setCommandClass(Movie.class);
    }
	
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
    	Map m = new HashMap();
    	m.put("directors", directorManager.getAll(null, null, null));
    	m.put("allgenres", genreManager.getAll());
		return m;
	}
	
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
        
		if (!isFormSubmission(request)) {
        	Movie movie;
        	
        	if (StringUtils.isNotEmpty(id) && !isAdd(request)) {
        		movie = movieManager.getMovieById(Long.parseLong(id));
        	} else {
        		movie = new Movie();
        		movie.setImage(ApplicationConstants.MOVIE_DEFAULT_IMAGE);
        	}
        	
            return movie;

		} else {
			Movie movie = new Movie();
			movie.setImage(ApplicationConstants.MOVIE_DEFAULT_IMAGE);
			return movie;
		}
		
	}
	
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			log.debug("Not modifying nor deleting movie...");
			if (StringUtils.equals(request.getParameter("from"), "list")) {
				return new ModelAndView(new RedirectView("movies.html"));
			} else {
				saveInfoMessage(request, getText("info.updates.not.committed", request.getLocale()));
				return new ModelAndView(new RedirectView("movieForm.html"));
			}
		}
		return super.processFormSubmission(request, response, command, errors);
	}
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		Movie movie = (Movie) command;
		
		Movie prevMovie = movieManager.getMovieById(movie.getId());
		
		if(prevMovie != null) {
			BeanUtils.copyProperties(movie, prevMovie, new String[]{"image", "dateAdded"});
			try {
				log.debug("Trying to update movie with title: "+movie.getTitle());
				movieManager.updateMovie(prevMovie);
				saveSuccessMessage(request, getText("success.user.saved", request.getLocale()));
				log.debug("Movie "+movie.getTitle() + " updated. Id: "+movie.getId());
				 
			} catch(Exception e) {
				saveErrorMessage(request, getText("errors.generic", request.getLocale()));
				log.error("Errore nella modifica di un film", e);
			}
			
		} else {
			
			try {
				log.debug("Trying to save new movie with title: "+movie.getTitle());
				movie.setDateAdded(new Date());
				movieManager.addMovie(movie);
				saveSuccessMessage(request, getText("success.user.saved", request.getLocale()));
				log.debug("Movie "+movie.getTitle() + " saved. Id: "+movie.getId());
				 
			} catch(Exception e) {
				saveErrorMessage(request, getText("errors.generic", request.getLocale()));
				log.error("Errore nel salvataggio di un film", e);
			}
		}
		

		if (StringUtils.equals(request.getParameter("from"), "list")) {
			return new ModelAndView(new RedirectView("movies.html"));
			
		} else {
			
			return showForm(request, response, errors);
		}
		
	}
	
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
//		binder.registerCustomEditor(Genre.class, new GenrePropertyEditor(genreManager));
		binder.registerCustomEditor(Set.class, "genres", new CustomCollectionEditor(Set.class)
		  {
			protected Object convertElement(Object element) {
	               if (element != null) {
	                   Long id = new Long((String)element);
	                   Genre genre = genreManager.getGenreById(id);
	                   return genre;
	               }
	               return null;
	           }
		  });
	}
	
	
	protected boolean isAdd(HttpServletRequest request) {
        String method = request.getParameter("method");
        return (method != null && method.equalsIgnoreCase("add"));
    }
	
}