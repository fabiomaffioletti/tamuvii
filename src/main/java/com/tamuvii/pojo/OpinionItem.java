package com.tamuvii.pojo;

import com.tamuvii.model.Opinion;


public class OpinionItem {
	private Opinion opinion;
	private UserInfo userInfo;
	
	public Opinion getOpinion() {
		return opinion;
	}
	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}