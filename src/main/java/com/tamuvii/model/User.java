package com.tamuvii.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

public class User implements UserDetails {
	private static final long serialVersionUID = -4102524992788195061L;

	private Long id;
	private String username;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String email;
	private Date dateAdded;
	private String avatar;
	private String websiteTitle;
	private String websiteUrl;
	private boolean canInvite;
	private Set<Role> roles = new HashSet<Role>();
    private boolean enabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    
    
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
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
        getRoles().add(role);
    }
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
    
	
    public GrantedAuthority[] getAuthorities() {
        return roles.toArray(new GrantedAuthority[0]);
    }
}