package com.tamuvii.observer.events;

public interface TamuviiEvent {
	
	public EventType getType();
	public void setEventProperty(String key, Object value);
	public Object getEventProperty(String key);

}
