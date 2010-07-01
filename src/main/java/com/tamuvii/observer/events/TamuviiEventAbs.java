package com.tamuvii.observer.events;

import java.util.HashMap;

public abstract class TamuviiEventAbs implements TamuviiEvent {
	private EventType eventType;
	private Object source;
	private HashMap<String, Object> eventProperties = new HashMap<String, Object>();

	public TamuviiEventAbs(EventType eventType, Object source){
		this.eventType = eventType;
		this.source = source;
	}
	
	public EventType getType() {
		return eventType;
	}
	
	public Object getSource() {
		return source;
	}

	public void setEventProperty(String key, Object value){
		this.eventProperties.put(key, value);
	}
	
	public Object getEventProperty(String key){
		return this.eventProperties.get(key);
	}

}
