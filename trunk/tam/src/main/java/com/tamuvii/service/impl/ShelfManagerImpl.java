package com.tamuvii.service.impl;

import java.util.List;
import java.util.Map;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.MovieItemBelonging;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.UserInfo;
import com.tamuvii.service.MovieManager;
import com.tamuvii.service.ShelfManager;
import com.tamuvii.service.UserManager;
import com.tamuvii.service.UserMovieManager;
import com.tamuvii.util.RequestUtils;

public class ShelfManagerImpl implements ShelfManager {
	private UserMovieManager userMovieManager = null;
	private UserManager userManager = null;
	private MovieManager movieManager = null;
	
	public void setMovieManager(MovieManager movieManager) {
		this.movieManager = movieManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public void setUserMovieManager(UserMovieManager userMovieManager) {
		this.userMovieManager = userMovieManager;
	}
	
	
	public UserInfo getUserInfo(String username) {
		username = RequestUtils.getRequestUsername(username);
		UserInfo userInfo = userManager.getUserInfo(username);
		userInfo.setFriends(userManager.getFriends(username, 0, ApplicationConstants.FRIENDS_ITEMS_SHELF, ApplicationConstants.ORDER_RANDOM, null));
		userInfo.setFriendsCount(userManager.getFriendsCount(username, null));
		userInfo.setNearbies(userManager.getNearbies(username, 0, ApplicationConstants.NEARBIES_ITEMS_SHELF, ApplicationConstants.ORDER_RANDOM, null));
		userInfo.setNearbiesCount(userManager.getNearbiesCount(username, null));
		return userInfo;
	}

	public List<ShelfItem> getShelfItems(String filter, String username, Integer from, Integer to) {
		username = RequestUtils.getRequestUsername(username);
		return userMovieManager.getAllShelf(filter, username, from, to);
	}
	public Integer getShelfItemsCount(String filter, String username) {
		username = RequestUtils.getRequestUsername(username);
		return userMovieManager.getAllShelfCount(filter, username);
	}

	public List<ShelfItem> getWishlistItems(String filter, String username, Integer from, Integer to) {
		username = RequestUtils.getRequestUsername(username);
		return userMovieManager.getAllWishlist(filter, username, from, to);
	}
	public Integer getWishlistItemsCount(String filter, String username) {
		username = RequestUtils.getRequestUsername(username);
		return userMovieManager.getAllWishlistCount(filter, username);
	}
	
	
	public Integer getRelationship(String first, String username) {
		return userManager.getRelationship(first, username);
	}
	public List<ShelfItem> getAllItems(String username, Integer from, Integer to) {
		return userMovieManager.getAll(username, from, to);
	}
	public List<UserInfo> getLastRegistered(Integer num) {
		return userManager.getLastRegistered(num);
	}
	public List<MovieItem> getLastAdded(Integer num) {
		return movieManager.getLastAdded(num);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ShelfItem> getItemsBelongings(String remoteUser, String username, List<ShelfItem> items) {
		Map belongings = userMovieManager.getShelfItemBelonging(remoteUser, username, items);
		for (ShelfItem shelfItem : items) {
			MovieItemBelonging mib = ((MovieItemBelonging) belongings.get(shelfItem.getMovie().getId()));
			shelfItem.setBelonging(mib!=null?(Integer)mib.getWishlist():-1);
		}
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public List<MovieItem> getItemsBelongings(String remoteUser, List<MovieItem> items) {
		Map belongings = userMovieManager.getMovieItemBelonging(remoteUser, items);
		for (MovieItem movieItem : items) {
			MovieItemBelonging mib = ((MovieItemBelonging) belongings.get(movieItem.getMovie().getId()));
			movieItem.setBelonging(mib!=null?(Integer)mib.getWishlist():-1);
		}
		return items;
	}
	
	public MovieItem getSingleItemBelongings(String remoteUser, MovieItem item) {
		Integer belonging = userMovieManager.getSingleMovieItemBelonging(remoteUser, item.getMovie().getId());
		item.setBelonging(belonging!=null?belonging:-1);
		return item;
	}
	
}