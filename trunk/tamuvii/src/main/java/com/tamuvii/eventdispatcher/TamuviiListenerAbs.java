package com.tamuvii.eventdispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tamuvii.logging.LoggingUtils;

public abstract class TamuviiListenerAbs implements TamuviiListener {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected List<TamuviiEventType> managedEvents;
	
	public List<TamuviiEventType> getManagedEvents() {
		return managedEvents;
	}

	public void setManagedEventsCSVList(String managedEventsStr) {
		log.debug("Setting managed events list..");
		this.managedEvents = new ArrayList<TamuviiEventType>();
		if (managedEventsStr != null && managedEventsStr.length() > 0) {
			log.debug("Parsing management events: "+managedEventsStr);
			StringTokenizer tokenizer = new StringTokenizer(
					managedEventsStr, ",");
			while (tokenizer.hasMoreElements()) {
				String token = tokenizer.nextToken();
				log.debug("Parsing event: "+token);
				try {
					this.managedEvents.add(TamuviiEventType.valueOf(TamuviiEventType.class, token));
					log.debug("Event parsed succesfully: "+token);
				} catch (Exception e) {
					log.error("Listener managed events are not configured properly, check applicationContext.xml\n"+ LoggingUtils.stackTraceToString(e));
					throw new RuntimeException("Listener managed events are not configured properly, check applicationContext.xml",e);
				}
			}
		}
		log.debug("Finished setting events list..");
	}

	public void onAmadeusEvent(TamuviiEvent event) throws Exception {
		if(isManagedEvent(event)){
			this.onManagedEvent(event);
		}
	}
	
	public boolean isManagedEvent(TamuviiEvent event){
		return (this.managedEvents == null ? false : this.managedEvents.contains(event.getType()));
	}
	
	protected abstract void onManagedEvent(TamuviiEvent event) throws Exception;

}
