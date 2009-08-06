package com.tamuvii.pojo;

import java.util.List;

public class Shelf {
	
	private List<ShelfItem> items;
	private Float itemsSize;
	
	public List<ShelfItem> getItems() {
		return items;
	}
	public void setItems(List<ShelfItem> items) {
		this.items = items;
	}
	public Integer getItemsSize() {
		return (int) Math.ceil(itemsSize/items.size());
	}
	public void setItemsSize(Float itemsSize) {
		this.itemsSize = itemsSize;
	}
	
}