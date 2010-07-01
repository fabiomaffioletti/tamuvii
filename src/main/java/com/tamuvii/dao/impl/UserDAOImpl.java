package com.tamuvii.dao.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.tamuvii.dao.UserDAO;
import com.tamuvii.model.Role;
import com.tamuvii.model.User;
import com.tamuvii.pojo.UserInfo;

public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO, UserDetailsService {
	
	@SuppressWarnings("unchecked")
	public List<User> getAll(Map queryMap) {
		List<User> users = getSqlMapClientTemplate().queryForList("user.getAll", queryMap);
		for (User user : users) {
			List<Role> roles = getSqlMapClientTemplate().queryForList("user.getUserRoles", user.getId());
			user.setRoles(new HashSet<Role>(roles));
		}
		return users; 
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		User user = (User) getSqlMapClientTemplate().queryForObject("user.getUserByUsername", username);
		List<Role> roles = getSqlMapClientTemplate().queryForList("user.getUserRoles", user.getId());
		user.setRoles(new HashSet<Role>(roles));
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByEmail(String email) {
		User user = (User) getSqlMapClientTemplate().queryForObject("user.getUserByEmail", email);
		List<Role> roles = getSqlMapClientTemplate().queryForList("user.getUserRoles", user.getId());
		user.setRoles(new HashSet<Role>(roles));
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserById(Long id) {
		User user = (User) getSqlMapClientTemplate().queryForObject("user.getUserById", id);
		List<Role> roles = getSqlMapClientTemplate().queryForList("user.getUserRoles", user.getId());
		user.setRoles(new HashSet<Role>(roles));
		return user;
	}
	
	private Long addUser(User user) {
		return (Long) getSqlMapClientTemplate().insert("user.addUser", user);
	}
	
	private void updateUser(User user) {
		getSqlMapClientTemplate().update("user.updateUser", user);
	}
	
	private void deleteUser(Long id) {
		getSqlMapClientTemplate().delete("user.deleteUser", id);
	}
	
	private void deleteUserRoles(Long id) {
		getSqlMapClientTemplate().delete("user.deleteUserRoles", id);
	}
	
	@SuppressWarnings("unchecked")
	private void addUserRoles(User user) {
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {
                Map<String, Long> newRole = new HashMap<String, Long>();
                newRole.put("userId", user.getId());
                newRole.put("roleId", role.getId());

                List<Role> userRoles = getSqlMapClientTemplate().queryForList("user.getUserRoles", user.getId());
                if (userRoles.isEmpty()) {
                    getSqlMapClientTemplate().update("user.addUserRole", newRole);
                }
            }
        }
    }
	
	
	public User saveUser(User user) {
        if (user.getId() == null) {
            Long id = addUser(user);
            user.setId(id);
        } else {
            updateUser(user);
            deleteUserRoles(user.getId());
        }
        addUserRoles(user);
        return user;
    }
	
	
	public void removeUser(Long id) {
        deleteUserRoles(id);
        deleteUser(id);
    }
	
	public String getUserPassword(String username) {
		return (String) getSqlMapClientTemplate().queryForObject("user.getUserPassword", username);
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = (User) getSqlMapClientTemplate().queryForObject("user.getUserByUsername", username);
		if(user == null)
			throw new UsernameNotFoundException("User '" + username + "' not found...");
		else {
			List roles = getSqlMapClientTemplate().queryForList("user.getUserRoles", user.getId());
            user.setRoles(new HashSet<Role>(roles));
		}
		
		return user;
	}

	@SuppressWarnings("unchecked")
	public List getFriends(Map queryMap) {
		List friends = getSqlMapClientTemplate().queryForList("user.getFriends", queryMap);
		return friends;
	}
	@SuppressWarnings("unchecked")
	public List getNearbies(Map queryMap) {
		List nearbies = getSqlMapClientTemplate().queryForList("user.getNearbies", queryMap);
		return nearbies;
	}
	@SuppressWarnings("unchecked")
	public Integer getFriendsCount(Map queryMap) {
		Integer friendsCount = (Integer) getSqlMapClientTemplate().queryForObject("user.getFriendsCount", queryMap);
		return friendsCount;
	}
	@SuppressWarnings("unchecked")
	public Integer getNearbiesCount(Map queryMap) {
		Integer nearbiesCount = (Integer) getSqlMapClientTemplate().queryForObject("user.getNearbiesCount", queryMap);
		return nearbiesCount;
	}

	@SuppressWarnings("unchecked")
	public void addFriend(Map queryMap) {
		getSqlMapClientTemplate().insert("user.addFriend", queryMap);
	}
	@SuppressWarnings("unchecked")
	public void addNearby(Map queryMap) {
		getSqlMapClientTemplate().insert("user.addNearby", queryMap);
	}
	@SuppressWarnings("unchecked")
	public void changeToFriend(Map queryMap) {
		getSqlMapClientTemplate().update("user.changeToFriend", queryMap);
	}
	@SuppressWarnings("unchecked")
	public void changeToNearby(Map queryMap) {
		getSqlMapClientTemplate().update("user.changeToNearby", queryMap);		
	}
	@SuppressWarnings("unchecked")
	public void deleteRelationship(Map queryMap) {
		getSqlMapClientTemplate().delete("user.deleteRelationship", queryMap);
	}

	public UserInfo getUserInfo(String username) {
		return (UserInfo) getSqlMapClientTemplate().queryForObject("user.getUserInfo", username);
	}

	public Integer getRelationship(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user.getRelationship", queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> getLastRegistered(Integer num) {
		return getSqlMapClientTemplate().queryForList("user.getLastRegistered", num);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> getFriendsByMovie(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("user.getFriendsByMovie", queryMap);
	}

	@SuppressWarnings("unchecked")
	public Integer getFriendsByMovieCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user.getFriendsByMovieCount", queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> getNearbiesByMovie(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("user.getNearbiesByMovie", queryMap);
	}

	@SuppressWarnings("unchecked")
	public Integer getNearbiesByMovieCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user.getNearbiesByMovieCount", queryMap);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> getUsersByMovie(Map queryMap) {
		return getSqlMapClientTemplate().queryForList("user.getUsersByMovie", queryMap);
	}

	@SuppressWarnings("unchecked")
	public Integer getUsersByMovieCount(Map queryMap) {
		return (Integer) getSqlMapClientTemplate().queryForObject("user.getUsersByMovieCount", queryMap);
	}

	public void enableUser(Long id) {
		getSqlMapClientTemplate().update("user.enableUser", id);
	}

	public void updateUserAvatar(User user) {
		getSqlMapClientTemplate().update("user.updateUserAvatar", user);
	}

}