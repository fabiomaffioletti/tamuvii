package com.tamuvii.model;

import org.springframework.security.GrantedAuthority;

public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 6915009472725040481L;
	
	private Long id;
    private String name;
    private String description;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthority() {
        return getName();
    }
	public int compareTo(Object o) {
        return (equals(o) ? 0 : -1);
    }
    
}