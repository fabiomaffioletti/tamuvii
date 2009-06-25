package com.tamuvii.pojo;

import java.util.Date;
import java.util.List;

import com.tamuvii.model.Address;

public class UserNeighbor {
	
	private Long id;
    private String username;                   
    private String email;                      
    private String website;
    private String websiteTitle;
	private Address address = new Address();
	private String imageLink;
	private Date dateAdded;
	private List<ShelfItem> lastMovies;
	private Integer totMovies;
    
    public Integer getTotMovies() {
		return totMovies;
	}
	public void setTotMovies(Integer totMovies) {
		this.totMovies = totMovies;
	}
	public List<ShelfItem> getLastMovies() {
		return lastMovies;
	}
	public void setLastMovies(List<ShelfItem> lastMovies) {
		this.lastMovies = lastMovies;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getWebsiteTitle() {
		return websiteTitle;
	}
	public void setWebsiteTitle(String websiteTitle) {
		this.websiteTitle = websiteTitle;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
    
}