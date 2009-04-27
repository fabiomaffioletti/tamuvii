package com.tamuvii.eventdispatcher;

import java.util.List;

public interface TamuviiListener {
	
	public void onTamuviiEvent(TamuviiEvent event) throws Exception;
	
	/**
	 * Set the events managed by the lister as a comma delimited list of
	 * string. The allowed names are the names of the EventType enumeration
	 * @param managedEvents comma delimited names of the managed events
	 */
	public void setManagedEventsCSVList(String managedEvents);
	
	public List<TamuviiEventType> getManagedEvents();
	
	public boolean isManagedEvent(TamuviiEvent event);
	

}
