package com.tamuvii.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.tamuvii.dao.CustomMovieDAO;
import com.tamuvii.pojo.DetailedReview;
import com.tamuvii.pojo.MovieUser;
import com.tamuvii.pojo.PersonalMovie;
import com.tamuvii.pojo.PersonalMovieIdAndWishedFlag;
import com.tamuvii.pojo.SearchMovieFilter;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.pojo.UserNeighbor;
import com.tamuvii.pojo.queryfilter.PersonalMovieFilterMap;

public class CustomMovieDAOImpl extends SqlMapClientDaoSupport implements CustomMovieDAO {
	
	public CustomMovieDAOImpl() {
		super();
	}

	public SocialMovie getSocialMovieDetails(Integer movie) {
		return (SocialMovie) getSqlMapClientTemplate().queryForObject("custom_movie.getSocialMovieDetails", movie);
	}

	public PersonalMovie getPersonalMovieDetails(PersonalMovieFilterMap personalMovieFilterMap) {
		PersonalMovie personalMovie = (PersonalMovie) getSqlMapClientTemplate().queryForObject("custom_movie.getPersonalMovieDetails", personalMovieFilterMap);
		return personalMovie;
	}

	@SuppressWarnings("unchecked")
	public List<DetailedReview> getDetailedReviewsByMovie(Integer movie) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getDetailedReviewsByMovie", movie);
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieUser> getUsersByMovie(Integer movie) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getUsersByMovie", movie);
	}

	@SuppressWarnings("unchecked")
	public List<SocialMovie> searchSocialMovie(SearchMovieFilter searchMovieFilter) {
		return getSqlMapClientTemplate().queryForList("custom_movie.searchSocialMovies", searchMovieFilter);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getPersonalMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getPersonalMoviesIds", username);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getShelfMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getShelfMoviesIds", username);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getWishedMoviesIds(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getWishedMoviesIds", username);
	}

	@SuppressWarnings("unchecked")
	public List<PersonalMovieIdAndWishedFlag> getPersonalMoviesIdsAndWishedFlags(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getPersonalMoviesIdsAndWishedFlags", username);
	}

	@SuppressWarnings("unchecked")
	public List<UserNeighbor> getUserFriends(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getUserFriends", username);
	}

	@SuppressWarnings("unchecked")
	public List<UserNeighbor> getUserNeighborhoods(String username) {
		return getSqlMapClientTemplate().queryForList("custom_movie.getUserNeighborhoods", username);
	}

	public UserNeighbor getUserPublicInfo(String username) {
		return (UserNeighbor) getSqlMapClientTemplate().queryForObject("custom_movie.getUserPublicInfo", username);
	}
	
}