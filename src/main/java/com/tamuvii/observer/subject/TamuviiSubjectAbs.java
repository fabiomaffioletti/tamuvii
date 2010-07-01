package com.tamuvii.observer.subject;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tamuvii.observer.events.TamuviiEvent;
import com.tamuvii.observer.listeners.TamuviiListener;

public class TamuviiSubjectAbs implements TamuviiSubject{
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	private List<TamuviiListener> listeners = new ArrayList<TamuviiListener>();

	public void addListener(TamuviiListener listener) {
		this.listeners.add(listener);
		
	}

	public void removeListener(TamuviiListener listener) {
		this.listeners.remove(listener);
	}
	
	public List<TamuviiListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<TamuviiListener> listeners) {
		if(listeners != null){
			log.debug("Start adding listeners..");
			for (TamuviiListener tamuviiListener : listeners) {
				log.debug("    Add "+tamuviiListener.getClass());
			}
			this.listeners = listeners;
		}
	}

	public void notifyListeners(TamuviiEvent e) throws Exception {
		log.debug("Start notify listeners of scanpass event: "+e.getType());
		for (TamuviiListener listener : listeners) {
			log.debug("send event "+e.getType()+" to "+listener.getClass().getName());
			listener.onScanPassEvent(e);
		}
		
	}

}
