package com.tamuvii.pojo.queryfilter;

public class ShelfDirectorReportFilter {
	
	private String username;
	private Integer from;
	private Integer to;
	private String orderAttribute;
	
	
	public String getOrderAttribute() {
		return orderAttribute;
	}
	public void setOrderAttribute(String orderAttribute) {
		this.orderAttribute = orderAttribute;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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

}