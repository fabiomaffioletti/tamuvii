package com.tamuvii.pojo;

import java.util.List;
import java.util.Map;

import com.tamuvii.model.Director;
import com.tamuvii.model.Movie;

public class MovieItem {
	private Movie movie;
	private Director director;
	private Float avgMark;
	private Integer userCount;
	private Integer reviewCount;
	private Map<String, Integer> marks;
	private Integer belonging;
	private List<UserInfo> users;
	private Integer usersCount;
	private List<UserInfo> friends;
	private Integer friendsCount;
	private List<UserInfo> nearbies;
	private Integer nearbiesCount;
	private List<ReviewItem> reviews;
	
	public List<ReviewItem> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewItem> reviews) {
		this.reviews = reviews;
	}
	public List<UserInfo> getUsers() {
		return users;
	}
	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}
	public Integer getUsersCount() {
		return usersCount;
	}
	public void setUsersCount(Integer usersCount) {
		this.usersCount = usersCount;
	}
	public List<UserInfo> getFriends() {
		return friends;
	}
	public void setFriends(List<UserInfo> friends) {
		this.friends = friends;
	}
	public Integer getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(Integer friendsCount) {
		this.friendsCount = friendsCount;
	}
	public List<UserInfo> getNearbies() {
		return nearbies;
	}
	public void setNearbies(List<UserInfo> nearbies) {
		this.nearbies = nearbies;
	}
	public Integer getNearbiesCount() {
		return nearbiesCount;
	}
	public void setNearbiesCount(Integer nearbiesCount) {
		this.nearbiesCount = nearbiesCount;
	}
	public Integer getBelonging() {
		return belonging;
	}
	public void setBelonging(Integer belonging) {
		this.belonging = belonging;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public Float getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(Float avgMark) {
		this.avgMark = avgMark;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	
}