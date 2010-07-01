package com.tamuvii.pojo;

import java.util.Date;
import java.util.List;

public class UserInfo {
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private Date dateAdded;
	private String avatar;
	private String websiteTitle;
	private String websiteUrl;
	private boolean canInvite;
	private Integer reviewCount;
	private List<UserInfo> friends;
	private Integer friendsCount;
	private List<UserInfo> nearbies;
	private Integer nearbiesCount;
	
	public boolean isCanInvite() {
		return canInvite;
	}
	public void setCanInvite(boolean canInvite) {
		this.canInvite = canInvite;
	}
	public String getWebsiteTitle() {
		return websiteTitle;
	}
	public void setWebsiteTitle(String websiteTitle) {
		this.websiteTitle = websiteTitle;
	}
	public String getWebsiteUrl() {
		return websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public List<UserInfo> getFriends() {
		return friends;
	}
	public void setFriends(List<UserInfo> friends) {
		this.friends = friends;
	}
	public List<UserInfo> getNearbies() {
		return nearbies;
	}
	public void setNearbies(List<UserInfo> nearbies) {
		this.nearbies = nearbies;
	}
	public Integer getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(Integer friendsCount) {
		this.friendsCount = friendsCount;
	}
	public Integer getNearbiesCount() {
		return nearbiesCount;
	}
	public void setNearbiesCount(Integer nearbiesCount) {
		this.nearbiesCount = nearbiesCount;
	}
	
}