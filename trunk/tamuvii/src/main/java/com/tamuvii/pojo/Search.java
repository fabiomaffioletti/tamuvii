package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.util.TamuviiConstants;

public class Search {
	
	private List<SocialMovie> items;
	private Float itemsSize;
	private Integer currentPage;
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<SocialMovie> getItems() {
		return items;
	}
	public void setItems(List<SocialMovie> items) {
		this.items = items;
	}
	public Integer getItemsSize() {
		return (int) Math.ceil(itemsSize/TamuviiConstants.MOVIES_PER_PAGE);
	}
	public void setItemsSize(Float itemsSize) {
		this.itemsSize = itemsSize;
	}
	
}