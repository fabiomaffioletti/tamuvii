package com.tamuvii.pojo;

import java.util.List;

import com.tamuvii.util.TamuviiConstants;

public class Shelf {
	
	private List<ShelfItem> items;
	private Float itemsSize;
	private Integer currentPage;
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<ShelfItem> getItems() {
		return items;
	}
	public void setItems(List<ShelfItem> items) {
		this.items = items;
	}
	public Integer getItemsSize() {
		return (int) Math.ceil(itemsSize/TamuviiConstants.MOVIES_PER_PAGE);
	}
	public void setItemsSize(Float itemsSize) {
		this.itemsSize = itemsSize;
	}
	
}