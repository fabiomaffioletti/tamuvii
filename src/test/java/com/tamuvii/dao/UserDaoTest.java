package com.tamuvii.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tamuvii.ApplicationConstants;
import com.tamuvii.model.Role;
import com.tamuvii.model.User;
import com.tamuvii.pojo.UserInfo;

public class UserDaoTest extends ApplicationTest {
	private UserDAO userDao = null;
	private RoleDAO roleDao = null;

	public void setRoleDao(RoleDAO roleDao) {
		this.roleDao = roleDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public void testGetUserInfo() {
		UserInfo ui = userDao.getUserInfo("fubbyo");
		assertNotNull(ui);
		assertEquals("fabio", ui.getFirstName());
		assertTrue(ui.getReviewCount() == 2);
	}
	
	
	@SuppressWarnings("unchecked")
	public void testGetAll() {
		Map queryMap = new HashMap();
		queryMap.put("from", 0);
		queryMap.put("to", 1);
		List<User> users = userDao.getAll(queryMap);
		assertTrue(users.size() == 1);
		
		queryMap = new HashMap();
		queryMap.put("from", 0);
		queryMap.put("to", 2);
		users = userDao.getAll(queryMap);
		assertTrue(users.size() == 2);
	}
	
	public void testGetUserByUsername() {
		String username = "admin";
		User user = userDao.getUserByUsername(username);
		assertNotNull(user);
		assertNotNull(user.getRoles());
	}
	public void testGetUserByEmail() {
		String email = "admin.admin@company.com";
		User user = userDao.getUserByEmail(email);
		assertNotNull(user);
		assertNotNull(user.getRoles());
	}
	public void testGetUserById() {
		Long id = 2L;
		User user = userDao.getUserById(id);
		assertNotNull(user);
		
		id = -1L;
		try {
			user = userDao.getUserById(id);
			fail();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void testRemoveUser() {
		userDao.removeUser(1L);
	}
	public void testSaveUser() {
		User user = new User();
		user.setUsername("test-user");
		user.setPassword("dkoshafguidhsjdfshgil");
		user.setFirstName("test");
		user.setLastName("user");
		user.setDateAdded(new Date());
		user.setEmail("test-user@testuser.com");
		user.setEnabled(true);
		user.setAccountLocked(false);
		user.setAccountExpired(false);
		user.setCredentialsExpired(false);
		
		Role role = roleDao.getRoleByName(ApplicationConstants.ROLE_ADMIN);
		user.addRole(role);
		
		user = userDao.saveUser(user);
		assertNotNull(user);
		assertNotNull(user.getRoles());
		assertTrue(user.getRoles().size() > 0);
		assertEquals(ApplicationConstants.ROLE_ADMIN, ((Role) user.getRoles().toArray()[0]).getName());
	}
	
	
	@SuppressWarnings("unchecked")
	public void testGetFriends() {
		Map queryMap = new HashMap();
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		queryMap.put("username", "fubbyo");
		queryMap.put("filter", null);
		
		List friends = userDao.getFriends(queryMap);
		assertTrue(friends.size() == 3);
		
		Integer friendsCount = userDao.getFriendsCount(queryMap);
		assertTrue(friendsCount == 3);
	}
	@SuppressWarnings("unchecked")
	public void testGetNearbies() {
		Map queryMap = new HashMap();
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		queryMap.put("username", "fubbyo");
		
		List nearbies = userDao.getNearbies(queryMap);
		assertTrue(nearbies.size() == 1);
		
		Integer nearbiesCount = userDao.getNearbiesCount(queryMap);
		assertTrue(nearbiesCount == 1);
	}
	
	
	@SuppressWarnings("unchecked")
	public void testAddFriend() {
		Map queryMap = new HashMap();
		queryMap.put("first", "user");
		queryMap.put("second", "fubbyo");
		queryMap.put("date_added", new Date());
		userDao.addFriend(queryMap);
		
		queryMap = new HashMap();
		queryMap.put("username", "user");
		assertTrue(userDao.getFriendsCount(queryMap) == 1);
	}
	@SuppressWarnings("unchecked")
	public void testAddNearby() {
		Map queryMap = new HashMap();
		queryMap.put("first", "user");
		queryMap.put("second", "fubbyo");
		queryMap.put("date_added", new Date());
		userDao.addNearby(queryMap);
		
		queryMap = new HashMap();
		queryMap.put("username", "user");
		assertTrue(userDao.getNearbiesCount(queryMap) == 1);
	}
	@SuppressWarnings("unchecked")
	public void testChangeToFriend() {
		Map queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("second", "andrea");
		userDao.changeToFriend(queryMap);
	}
	@SuppressWarnings("unchecked")
	public void testChangeToNearby() {
		Map queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("second", "irene");
		userDao.changeToNearby(queryMap);
	}
	@SuppressWarnings("unchecked")
	public void testDeleteRelationship() {
		Map queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("second", "andrea");
		userDao.deleteRelationship(queryMap);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetRelationship() {
		Map queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("second", "andrea");
		assertTrue(userDao.getRelationship(queryMap) == 0);
		queryMap = new HashMap();
		queryMap.put("first", "fubbyo");
		queryMap.put("second", "freddy");
		assertTrue(userDao.getRelationship(queryMap) == 1);
	}
	
	
	@SuppressWarnings("unchecked")
	public void testGetUsersByMovie() {
		Map queryMap = new HashMap();
		queryMap.put("movie", 3L);
		queryMap.put("from", 0);
		queryMap.put("to", 10);
		assertTrue(userDao.getUsersByMovie(queryMap).size() == 5);
		
		queryMap = new HashMap();
		queryMap.put("movie", 3L);
		assertTrue(userDao.getUsersByMovieCount(queryMap) == 5);
	}
	
}