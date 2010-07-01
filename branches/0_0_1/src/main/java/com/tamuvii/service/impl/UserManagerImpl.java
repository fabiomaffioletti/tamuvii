package com.tamuvii.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.security.userdetails.UserDetails;

import com.tamuvii.dao.UserDAO;
import com.tamuvii.exception.RelationshipException;
import com.tamuvii.exception.TamuviiException;
import com.tamuvii.exception.UserExistsException;
import com.tamuvii.model.User;
import com.tamuvii.observer.events.EventType;
import com.tamuvii.observer.events.TamuviiEvent;
import com.tamuvii.observer.events.TamuviiEventImpl;
import com.tamuvii.observer.subject.TamuviiSubject;
import com.tamuvii.pojo.UserInfo;
import com.tamuvii.service.UserManager;
import com.tamuvii.util.RequestUtils;

public class UserManagerImpl extends ApplicationManager implements UserManager {
	private PasswordEncoder passwordEncoder = null;
	private UserDAO userDao = null;
	private TamuviiSubject tamuviiEventDispatcher = null;
	
	public void setTamuviiEventDispatcher(TamuviiSubject tamuviiEventDispatcher) {
		this.tamuviiEventDispatcher = tamuviiEventDispatcher;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	/*
	 * DWR METHODS
	 */
	@SuppressWarnings("unchecked")
	public void addFriend(String username) throws RelationshipException {
		String first = RequestUtils.getRequestUsername(null);
		if(getRelationship(first, username) == null) {
			if(!first.equals(username)) {
				Map queryMap = new HashMap();
				queryMap.put("first", first);
				queryMap.put("second", username);
				queryMap.put("date_added", new Date());
				userDao.addFriend(queryMap);
				
				TamuviiEvent friendAddedEvent = new TamuviiEventImpl(EventType.FRIEND_ADDED, this);
				friendAddedEvent.setEventProperty("user", userDao.getUserByUsername(username));
				friendAddedEvent.setEventProperty("first", first);
				friendAddedEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				try {
					tamuviiEventDispatcher.notifyListeners(friendAddedEvent);
				} catch (Exception e) {
					log.error(e);
					throw new RelationshipException("Error while notifying listeners to event: FRIEND_ADDED: ", e);
				}
				
			} else {
				log.warn("User " + first + " trying to add himself as a friend");
				throw new RelationshipException("User " + first + " trying to add himself as a friend");
			}
		} else {
			log.warn("User " + first + " trying to re-add user " + username + " as a friend");
			throw new RelationshipException("User " + first + " trying to re-add user " + username + " as a friend");
		}
	}
	@SuppressWarnings("unchecked")
	public void addNearby(String username) throws RelationshipException {
		String first = RequestUtils.getRequestUsername(null);
		if(getRelationship(first, username) == null) {
			if(!first.equals(username)) {
				Map queryMap = new HashMap();
				queryMap.put("first", first);
				queryMap.put("second", username);
				queryMap.put("date_added", new Date());
				userDao.addNearby(queryMap);
				
				TamuviiEvent nearbieAddedEvent = new TamuviiEventImpl(EventType.NEARBY_ADDED, this);
				nearbieAddedEvent.setEventProperty("user", userDao.getUserByUsername(username));
				nearbieAddedEvent.setEventProperty("first", first);
				nearbieAddedEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				try {
					tamuviiEventDispatcher.notifyListeners(nearbieAddedEvent);
				} catch (Exception e) {
					log.error(e);
					throw new RelationshipException("Error while notifying listeners to event: NEARBIE_ADDED: ", e);
				}
				
			} else {
				log.warn("User "+username+" trying to add himself as a nearby");
				throw new RelationshipException("User "+username+" trying to add himself as a nearby");
			}
		} else {
			log.warn("User " + first + " trying to re-add user " + username + " as a nearby");
			throw new RelationshipException("User " + first + " trying to re-add user " + username + " as a nearby");
		}
	}
	@SuppressWarnings("unchecked")
	public void changeToFriend(String username) throws RelationshipException {
		String first = RequestUtils.getRequestUsername(null);
		if(getRelationship(first, username) == 0) {
			if(!first.equals(username)) {
				Map queryMap = new HashMap();
				queryMap.put("first", first);
				queryMap.put("second", username);
				userDao.changeToFriend(queryMap);
				
				TamuviiEvent relationshipChangedEvent = new TamuviiEventImpl(EventType.RELATIONSHIP_CHANGED, this);
				relationshipChangedEvent.setEventProperty("user", userDao.getUserByUsername(username));
				relationshipChangedEvent.setEventProperty("first", first);
				relationshipChangedEvent.setEventProperty("relationship", "amico");
				relationshipChangedEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				try {
					tamuviiEventDispatcher.notifyListeners(relationshipChangedEvent);
				} catch (Exception e) {
					log.error(e);
					throw new RelationshipException("Error while notifying listeners to event: RELATIONSHIP_CHANGED: ", e);
				}
				
			} else {
				log.warn("User " + first + " trying to change himself as a friend");
				throw new RelationshipException("User " + first + " trying to change himself as a friend");
			}
		} else {
			log.warn("User " + first + " trying to change a friend " + username + " to a friend");
			throw new RelationshipException("User " + first + " trying to change a friend " + username + " to a friend");
		}
	}
	@SuppressWarnings("unchecked")
	public void changeToNearby(String username) throws RelationshipException {
		String first = RequestUtils.getRequestUsername(null);
		if(getRelationship(first, username) == 1) {
			if(!first.equals(username)) {
				Map queryMap = new HashMap();
				queryMap.put("first", first);
				queryMap.put("second", username);
				userDao.changeToNearby(queryMap);
				
				TamuviiEvent relationshipChangedEvent = new TamuviiEventImpl(EventType.RELATIONSHIP_CHANGED, this);
				relationshipChangedEvent.setEventProperty("user", userDao.getUserByUsername(username));
				relationshipChangedEvent.setEventProperty("first", first);
				relationshipChangedEvent.setEventProperty("relationship", "vicino");
				relationshipChangedEvent.setEventProperty("appURL", RequestUtils.getDWRAppURL());
				try {
					tamuviiEventDispatcher.notifyListeners(relationshipChangedEvent);
				} catch (Exception e) {
					log.error(e);
					throw new RelationshipException("Error while notifying listeners to event: RELATIONSHIP_CHANGED: ", e);
				}
				
			} else {
				log.warn("User "+username+" trying to change himself as a nearby");
				throw new RelationshipException("User "+username+" trying to change himself as a nearby");
			}
		} else {
			log.warn("User " + first + " trying to change a nearby " + username + " to a nearby");
			throw new RelationshipException("User " + first + " trying to change a nearby " + username + " to a nearby");
		}
	}
	@SuppressWarnings("unchecked")
	public void deleteRelationship(String username) throws RelationshipException {
		String first = RequestUtils.getRequestUsername(null);
		if(!first.equals(username)) {
			Map queryMap = new HashMap();
			queryMap.put("first", first);
			queryMap.put("second", username);
			userDao.deleteRelationship(queryMap);
		} else {
			log.warn("User "+username+" trying to delete himself relationship");
			throw new RelationshipException("User "+username+" trying to delete himself relationship");
		}		
	}
	
	
	
	
	/*
	 * APPLICATION METHODS: SAVE/UPDATE/REMOVE
	 */
	public User saveUser(User user) throws UserExistsException {
		String currentPassword = userDao.getUserPassword(user.getUsername());
		if(!user.getPassword().equals(currentPassword)) {
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		}
		
		try {
			return userDao.saveUser(user);
		} catch (DataIntegrityViolationException e) {
			throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
		}
	}
	
	public User registerUser(User user, String appURL) throws UserExistsException, TamuviiException {
		String currentPassword = userDao.getUserPassword(user.getUsername());
		if(!user.getPassword().equals(currentPassword)) {
			user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		}
		
		try {
			User registeredUser = userDao.saveUser(user);
			
			TamuviiEvent registeredEvent = new TamuviiEventImpl(EventType.REGISTRATION_SUCCESS, this);
			registeredEvent.setEventProperty("user", user);
			registeredEvent.setEventProperty("appURL", appURL);
			try {
				tamuviiEventDispatcher.notifyListeners(registeredEvent);
			} catch (Exception e) {
				log.error(e);
				throw new TamuviiException("Error while notifying listeners to event: REGISTRATION_SUCCESS: ", e);
			}
			
			return registeredUser;
			
		} catch (DataIntegrityViolationException e) {
			throw new UserExistsException("User '" + user.getUsername() + "' already exists!");
		}
	}
	
	public void enableUser(String id) {
		userDao.enableUser(Long.parseLong(id));
	}
	
	public void updateUserAvatar(User user) {
		userDao.updateUserAvatar(user);
	}
	
	public void removeUser(String id) {
		userDao.removeUser(Long.parseLong(id));
	}
	
	
	/*
	 * APPLICATION METHODS: GETTERS
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAll(String filter, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("filter", StringUtils.isNotEmpty(filter)?filter.split(" "):null);
		if(from != null && to != null) {
			queryMap.put("from", from);
			queryMap.put("to", to);
		}
		return userDao.getAll(queryMap);
	}
	
	public User getUserById(String id) {
		return userDao.getUserById(Long.parseLong(id));
	}
	
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	public UserInfo getUserInfo(String username) {
		return userDao.getUserInfo(username);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getLastRegistered(Integer num) {
		return userDao.getLastRegistered(num);
	}

	
	/* 
	 * APPLICATION METHODS: RELATIONSHIPS
	 */
	@SuppressWarnings("unchecked")
	public Integer getRelationship(String username) {
		Map queryMap = new HashMap();
		queryMap.put("first", RequestUtils.getRequestUsername(null));
		queryMap.put("second", username);
		return userDao.getRelationship(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getRelationship(String first, String second) {
		Map queryMap = new HashMap();
		queryMap.put("first", first);
		queryMap.put("second", second);
		return userDao.getRelationship(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getFriends(String username, Integer from, Integer to, String order, String filter) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("from", from);
		queryMap.put("to", to);
		queryMap.put("order", order);
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return userDao.getFriends(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getFriendsCount(String username, String filter) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return userDao.getFriendsCount(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getNearbies(String username, Integer from, Integer to, String order, String filter) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("from", from);
		queryMap.put("to", to);
		queryMap.put("order", order);
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return userDao.getNearbies(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getNearbiesCount(String username, String filter) {
		Map queryMap = new HashMap();
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("filter", !StringUtils.isEmpty(filter)?filter.split(" "):null);
		return userDao.getNearbiesCount(queryMap);
	}
	
	
	
	
	/*
	 * APPLICATION METHODS: MOVIE/USERS
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> getFriendsByMovie(Long movie, String username, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("from", from);
		queryMap.put("to", to);
		return userDao.getFriendsByMovie(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getFriendsByMovieCount(Long movie, String username) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		return userDao.getFriendsByMovieCount(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getNearbiesByMovie(Long movie, String username, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		queryMap.put("from", from);
		queryMap.put("to", to);
		return userDao.getNearbiesByMovie(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getNearbiesByMovieCount(Long movie, String username) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("username", RequestUtils.getRequestUsername(username));
		return userDao.getNearbiesByMovieCount(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> getUsersByMovie(Long movie, Integer from, Integer to) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		queryMap.put("from", from);
		queryMap.put("to", to);
		return userDao.getUsersByMovie(queryMap);
	}
	@SuppressWarnings("unchecked")
	public Integer getUsersByMovieCount(Long movie) {
		Map queryMap = new HashMap();
		queryMap.put("movie", movie);
		return userDao.getUsersByMovieCount(queryMap);
	}
	
	
	
	
	// METODO PER LOGIN AUTOMATICO
	public UserDetails loadUserByUsername(String username) {
		return userDao.loadUserByUsername(username);
	}
	
}