package com.tamuvii.observer.listeners.abs;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tamuvii.observer.events.EventType;
import com.tamuvii.observer.events.TamuviiEvent;
import com.tamuvii.observer.listeners.TamuviiListener;

public abstract class TamuviiListenerAbs implements TamuviiListener {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected List<EventType> managedEvents;
	
	public List<EventType> getManagedEvents() {
		return managedEvents;
	}

	public void setManagedEventsCSVList(String managedEventsStr) {
		log.debug("Setting managed events list..");
		this.managedEvents = new ArrayList<EventType>();
		if (managedEventsStr != null && managedEventsStr.length() > 0) {
			log.debug("Parsing management events: "+managedEventsStr);
			StringTokenizer tokenizer = new StringTokenizer(
					managedEventsStr, ",");
			while (tokenizer.hasMoreElements()) {
				String token = tokenizer.nextToken();
				log.debug("Parsing event: "+token);
				try {
					this.managedEvents.add(EventType.valueOf(EventType.class, token));
					log.debug("Event parsed succesfully: "+token);
				} catch (Exception e) {
					log.error("Listener managed events are not configured properly, check applicationContext.xml", e);
					throw new RuntimeException("Listener managed events are not configured properly, check applicationContext.xml",e);
				}
			}
		}
		log.debug("Finished setting events list..");
	}

	public void onScanPassEvent(TamuviiEvent event) throws Exception {
		if(isManagedEvent(event)){
			this.onManagedEvent(event);
		}
	}
	
	public boolean isManagedEvent(TamuviiEvent event){
		return (this.managedEvents == null ? false : this.managedEvents.contains(event.getType()));
	}
	
	protected abstract void onManagedEvent(TamuviiEvent event) throws Exception;

}
