package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.MovieUser;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.SearchMovieFilter;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;

public interface CustomMovieDAO {
	
	public SocialMovie getSocialMovieDetails(Integer movie);
	
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie);
	
	public PersonalMovie getPersonalMovieDetails(PersonalMovieFilterMap personalMovieFilterMap);
	
	public List<MovieUser> getUsersByMovie(Integer movie);
	
	public List<SocialMovie> searchSocialMovie(SearchMovieFilter searchMovieFilter);
	
	public List<UserNeighbor> getUserFriends(String username);
	
	public List<UserNeighbor> getUserNeighborhoods(String username);
	
	public UserNeighbor getUserPublicInfo(String username);
	
}