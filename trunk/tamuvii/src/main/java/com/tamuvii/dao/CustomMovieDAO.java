package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.MovieUser;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;
import com.tamuvii.pojo.queryfilter.SocialMovieFilter;

public interface CustomMovieDAO {
	
	public SocialMovie getSocialMovieDetails(SocialMovieFilter smf);
	
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie);
	
	public PersonalMovie getPersonalMovieDetails(PersonalMovieFilterMap personalMovieFilterMap);
	
	public List<MovieUser> getUsersByMovie(SocialMovieFilter smf);
	
	public List<SocialMovie> searchSocialMovie(SocialMovieFilter searchMovieFilter);
	
}