package com.tamuvii.dao;

import java.util.List;

import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.MessageUserItem;
import com.tamuvii.pojo.MovieUser;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.SearchMovieFilter;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.pojo.queryfilter.MessageUserFilter;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;

public interface CustomMovieDAO {
	
	public List<ShelfItem> getShelfByUsername(String username);
	
	public List<ShelfItem> getWishedMoviesByUsername(String username);
	
	public SocialMovie getSocialMovieDetails(Integer movie);
	
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie);
	
	public PersonalMovie getPersonalMovieDetails(PersonalMovieFilterMap personalMovieFilterMap);
	
	public List<MovieUser> getUsersByMovie(Integer movie);
	
	public List<SocialMovie> searchSocialMovie(SearchMovieFilter searchMovieFilter);
	
	public List<Integer> getPersonalMoviesIds(String username);
	
	public List<Integer> getShelfMoviesIds(String username);
	
	public List<Integer> getWishedMoviesIds(String username);
	
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(String username);
	
	public List<UserNeighbor> getUserFriends(String username);
	
	public List<UserNeighbor> getUserNeighborhoods(String username);
	
	public List<MessageUserItem> getGroupedMessagesByUser(String username);

	public List<MessageUserItem> getInMessagesByUser(String username);

	public List<MessageUserItem> getConversationWithUser(MessageUserFilter messageUserFilter);

	public UserNeighbor getUserPublicInfo(String username);
	
}