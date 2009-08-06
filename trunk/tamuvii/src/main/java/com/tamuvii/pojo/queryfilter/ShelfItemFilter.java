package com.tamuvii.pojo.queryfilter;

public class ShelfItemFilter {
	
	private String username;
	private Integer director;
	private String orderAttribute;
	private String orderCriteria;
	private Integer from;
	private Integer to;

	
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	public Integer getDirector() {
		return director;
	}
	public void setDirector(Integer director) {
		this.director = director;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOrderCriteria() {
		return orderCriteria;
	}
	public void setOrderCriteria(String orderCriteria) {
		this.orderCriteria = orderCriteria;
	}
	public String getOrderAttribute() {
		return orderAttribute;
	}
	public void setOrderAttribute(String orderAttribute) {
		this.orderAttribute = orderAttribute;
	} 

}