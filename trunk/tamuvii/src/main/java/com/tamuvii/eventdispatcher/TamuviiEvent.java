package com.tamuvii.eventdispatcher;

public interface TamuviiEvent {
	
	public TamuviiEventType getType();
	public void setEventProperty(String key, Object value);
	public Object getEventProperty(String key);

}
