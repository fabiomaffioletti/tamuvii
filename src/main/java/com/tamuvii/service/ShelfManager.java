package com.tamuvii.service;

import java.util.List;

import com.tamuvii.pojo.MovieItem;
import com.tamuvii.pojo.ShelfItem;
import com.tamuvii.pojo.UserInfo;

public interface ShelfManager {
	
	public UserInfo getUserInfo(String username);
	public Integer getRelationship(String first, String username);
	
	public List<ShelfItem> getAllItems(String username, Integer from, Integer to);
	public List<UserInfo> getLastRegistered(Integer num);
	public List<MovieItem> getLastAdded(Integer num);
	
	public List<ShelfItem> getShelfItems(String filter, String username, Integer from, Integer to);
	public Integer getShelfItemsCount(String filter, String username);
	
	public List<ShelfItem> getWishlistItems(String filter, String username, Integer from, Integer to);
	public Integer getWishlistItemsCount(String filter, String username);

	public List<ShelfItem> getItemsBelongings(String remoteUser, String username, List<ShelfItem> items);
	public List<MovieItem> getItemsBelongings(String remoteUser, List<MovieItem> items);
	public MovieItem getSingleItemBelongings(String remoteUser, MovieItem item);
}