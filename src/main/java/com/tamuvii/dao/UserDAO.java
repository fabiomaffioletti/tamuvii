package com.tamuvii.dao;

import java.util.List;
import java.util.Map;

import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.tamuvii.model.User;
import com.tamuvii.pojo.UserInfo;

public interface UserDAO {
	
	@SuppressWarnings("unchecked")
	public List<User> getAll(Map queryMap);
	
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
	public User getUserById(Long id);
	public String getUserPassword(String username);
	
	public UserInfo getUserInfo(String username);
	
	public User saveUser(User user);
	public void updateUserAvatar(User user);
	public void enableUser(Long id);
	public void removeUser(Long id);
	
	public Integer getRelationship(Map queryMap);
	public List getFriends(Map queryMap);
	public Integer getFriendsCount(Map queryMap);
	public List getNearbies(Map queryMap);
	public Integer getNearbiesCount(Map queryMap);
	
	public void addFriend(Map queryMap);
	public void addNearby(Map queryMap);
	public void changeToFriend(Map queryMap);
	public void changeToNearby(Map queryMap);
	public void deleteRelationship(Map queryMap);
	
	public List getLastRegistered(Integer num);
	
	public List<UserInfo> getUsersByMovie(Map queryMap);
	public Integer getUsersByMovieCount(Map queryMap);
	public List<UserInfo> getFriendsByMovie(Map queryMap);
	public Integer getFriendsByMovieCount(Map queryMap);
	public List<UserInfo> getNearbiesByMovie(Map queryMap);
	public Integer getNearbiesByMovieCount(Map queryMap);
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}