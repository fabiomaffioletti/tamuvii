package com.tamuvii.webapp.controller;

import java.util.List;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.tamuvii.model.Movie;

public class SearchMovieControllerTest extends BaseControllerTestCase {
	private SearchMovieController searchMovieController = null;
	
	 public void setSearchMovieController(SearchMovieController searchMovieController) {
		this.searchMovieController = searchMovieController;
	}



	@SuppressWarnings("unchecked")
	public void testHandleRequest() throws Exception {
		 MockHttpServletRequest request = new MockHttpServletRequest();
		 MockHttpServletResponse response = new MockHttpServletResponse();
		 
		 request.addParameter("filter", "giusta");
		 ModelAndView mv = searchMovieController.handleRequest(request, response);
		 assertTrue(mv.getModel().containsKey("movieList"));
		 List<Movie> movieList = (List<Movie>) mv.getModel().get("movieList");
		 assertTrue( movieList.size() == 2 );
	 }

}
