package com.tamuvii.observer.listeners;

import java.util.List;

import com.tamuvii.observer.events.EventType;
import com.tamuvii.observer.events.TamuviiEvent;

public interface TamuviiListener {
	
	public void onScanPassEvent(TamuviiEvent event) throws Exception;
	
	/**
	 * Set the events managed by the lister as a comma delimited list of
	 * string. The allowed names are the names of the EventType enumeration
	 * @param managedEvents comma delimited names of the managed events
	 */
	public void setManagedEventsCSVList(String managedEvents);
	
	public List<EventType> getManagedEvents();
	
	public boolean isManagedEvent(TamuviiEvent event);
	

}
