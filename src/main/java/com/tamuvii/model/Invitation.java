package com.tamuvii.model;

import java.util.Date;


public class Invitation {
    private Long id;
    private Long user;
    private String userEmail;
    private String code;
    private String invitedEmail;
    private Date dateSent;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInvitedEmail() {
		return invitedEmail;
	}
	public void setInvitedEmail(String invitedEmail) {
		this.invitedEmail = invitedEmail;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
    
    
}