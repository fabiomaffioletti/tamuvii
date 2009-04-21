package com.tamuvii.service.impl;

import java.util.Calendar;

import com.tamuvii.dao.UserToMovieDAO;
import com.tamuvii.model.UserToMovie;
import com.tamuvii.model.UserToMovieExample;
import com.tamuvii.model.UserToMovieKey;
import com.tamuvii.model.UserToMovieExample.Criteria;
import com.tamuvii.pojo.SocialMovie;
import com.tamuvii.service.UserToMovieManager;

public class UserToMovieManagerImpl implements UserToMovieManager {
	private UserToMovieDAO userToMovieDao = null;

	public void setUserToMovieDao(UserToMovieDAO userToMovieDao) {
		this.userToMovieDao = userToMovieDao;
	}


	public void updatePersonalMovieDetails(UserToMovie userToMovie) {
		userToMovieDao.updateByPrimaryKeySelective(userToMovie);
	}

	public void addMovieToShelf(Integer movie, String username) {
		if(!doesMovieBelongToUserShelf(movie, username)) {
			UserToMovie userToMovie = new UserToMovie();
			userToMovie.setMovie(movie);
			userToMovie.setUsername(username);
			userToMovie.setDateadded(Calendar.getInstance().getTime());
			userToMovie.setDateviewed(null);
			userToMovie.setMark(null);
			userToMovie.setWished(0);
			userToMovieDao.insert(userToMovie);
		}
	}
	
	public void addMovieToWishlist(Integer movie, String username) {
		if(!doesMovieBelongToUserWishlist(movie, username) && !doesMovieBelongToUserShelf(movie, username)) {
			UserToMovie userToMovie = new UserToMovie();
			userToMovie.setMovie(movie);
			userToMovie.setUsername(username);
			userToMovie.setDateadded(Calendar.getInstance().getTime());
			userToMovie.setDateviewed(null);
			userToMovie.setMark(null);
			userToMovie.setWished(1);
			userToMovieDao.insert(userToMovie);
		}
	}

	public boolean doesMovieBelongToUserShelf(Integer movie, String username) {
		UserToMovieExample userToMovieExample = new UserToMovieExample();
		Criteria userToMovieCriteria = userToMovieExample.createCriteria();
		userToMovieCriteria.andMovieEqualTo(movie);
		userToMovieCriteria.andUsernameEqualTo(username);
		userToMovieCriteria.andWishedEqualTo(0);
		return userToMovieDao.selectByExample(userToMovieExample).size() > 0;
	}
	
	public boolean doesMovieBelongToUserWishlist(Integer movie, String username) {
		UserToMovieExample userToMovieExample = new UserToMovieExample();
		Criteria userToMovieCriteria = userToMovieExample.createCriteria();
		userToMovieCriteria.andMovieEqualTo(movie);
		userToMovieCriteria.andUsernameEqualTo(username);
		userToMovieCriteria.andWishedEqualTo(1);
		return userToMovieDao.selectByExample(userToMovieExample).size() > 0;
	}


	public void deleteMovieFromShelf(Integer movie, String username) {
		UserToMovieKey userToMovieKey = new UserToMovieKey();
		userToMovieKey.setMovie(movie);
		userToMovieKey.setUsername(username);
		userToMovieDao.deleteByPrimaryKey(userToMovieKey);
	}


	public void deleteMovieFromWishlist(Integer movie, String username) {
		UserToMovieKey userToMovieKey = new UserToMovieKey();
		userToMovieKey.setMovie(movie);
		userToMovieKey.setUsername(username);
		userToMovieDao.deleteByPrimaryKey(userToMovieKey);
	}


	public void moveMovieFromWishlistToShelf(Integer movie, String username) {
		UserToMovieKey userToMovieKey = new UserToMovieKey();
		userToMovieKey.setMovie(movie);
		userToMovieKey.setUsername(username);
		UserToMovie userToMovie = userToMovieDao.selectByPrimaryKey(userToMovieKey);
		userToMovie.setDateadded(Calendar.getInstance().getTime());
		userToMovie.setWished(0);
		userToMovieDao.updateByPrimaryKeySelective(userToMovie);
	}

}