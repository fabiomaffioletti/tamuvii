package com.tamuvii.service;

import java.util.List;

import org.springframework.security.userdetails.UserDetails;

import com.tamuvii.exception.RelationshipException;
import com.tamuvii.exception.TamuviiException;
import com.tamuvii.exception.UserExistsException;
import com.tamuvii.model.User;
import com.tamuvii.pojo.UserInfo;

public interface UserManager {
	
	public List<User> getAll(String filter, Integer from, Integer to);
	public User getUserById(String id);
	public User getUserByUsername(String username);
	
	public User saveUser(User user) throws UserExistsException;
	public void updateUserAvatar(User user);
	public User registerUser(User user, String appURL) throws UserExistsException, TamuviiException;
	public void removeUser(String id);
	public void enableUser(String id);
	
	public UserInfo getUserInfo(String username);
	
	public Integer getRelationship(String username);
	public Integer getRelationship(String first, String second);
	public List<UserInfo> getFriends(String username, Integer from, Integer to, String order, String filter);
	public Integer getFriendsCount(String username, String filter);
	public List<UserInfo> getNearbies(String username, Integer from, Integer to, String order, String filter);
	public Integer getNearbiesCount(String username, String filter);
	
	public void addFriend(String username) throws RelationshipException;
	public void addNearby(String username) throws RelationshipException;
	public void changeToFriend(String username) throws RelationshipException;
	public void changeToNearby(String username) throws RelationshipException;
	public void deleteRelationship(String username) throws RelationshipException;
	
	public List<UserInfo> getLastRegistered(Integer num);
	
	public List<UserInfo> getUsersByMovie(Long movie, Integer from, Integer to);
	public Integer getUsersByMovieCount(Long movie);
	public List<UserInfo> getFriendsByMovie(Long movie, String username, Integer from, Integer to);
	public Integer getFriendsByMovieCount(Long movie, String username);
	public List<UserInfo> getNearbiesByMovie(Long movie, String username, Integer from, Integer to);
	public Integer getNearbiesByMovieCount(Long movie, String username);
	
	public UserDetails loadUserByUsername(String username);
	
}